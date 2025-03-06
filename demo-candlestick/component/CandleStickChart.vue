<template>
    <div>
      <canvas ref="chartCanvas"></canvas>
    </div>
  </template>
  
  <script>
  import { Chart } from 'chart.js';
  import 'chartjs-chart-financial';
  import 'chartjs-adapter-date-fns'; // For date handling
  
  export default {
    name: 'CandleStickChart',
    data() {
      return {
        chart: null,
        candlestickData: []
      };
    },
    mounted() {
      this.fetchData();
    },
    methods: {
      async fetchData() {
        try {
          const response = await fetch('http://localhost:8097/candlestick1d');
          const data = await response.json();
          this.candlestickData = data.map(item => ({
            x: new Date(item[0]), // Timestamp
            o: item[1],           // Open
            h: item[2],           // High
            l: item[3],           // Low
            c: item[4]            // Close
          }));
          this.renderChart();
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      },
      renderChart() {
        const ctx = this.$refs.chartCanvas.getContext('2d');
        this.chart = new Chart(ctx, {
          type: 'candlestick',
          data: {
            datasets: [{
              label: 'Bitcoin 1D Candlestick',
              data: this.candlestickData
            }]
          },
          options: {
            scales: {
              x: {
                type: 'time',
                time: {
                  unit: 'hour'
                }
              },
              y: {
                beginAtZero: false
              }
            }
          }
        });
      }
    },
    beforeDestroy() {
      if (this.chart) {
        this.chart.destroy();
      }
    }
  };
  </script>
  
  <style scoped>
  canvas {
    max-width: 100%;
    height: 400px;
  }
  </style>