cd demo-coin-web
mvn clean install -DskipTests
cd ..
cd demo-sh-customer
mvn clean install -DskipTests
cd ..
docker compose build
docker compose up -d