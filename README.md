

- spring Context -> Store Beans
1.
    - Who create Beans, before sever start, "Spring Manager" manages bean cycle
    - Bean Cycle: @SpringBootApplication -> @ComponentScan 佢會自己找可以變 component
        @Contorller, @Service, @Configuration, @Respsitory
    - "Spring manager" creates objects for the above classes, put them into spring context
2.
    get beans from context
    - @Autowired on Class Attribute (Field Injection)
    - "Spring Manager" resolve this dependency by finding an appropriate object fit into the attribute type
    - @Autowired on contructor (Constuctor injection) 小人咁寫

3.
    - flow
    - Controller Bean always @Autowired Service Bean (Controller call Service Bean)
    - Service Bean always @Autowired Respository Bean (Service call Database Bean)
    - if "Spring Manager" cannot find any dependency, server start will fail
4.
    - RESTful API (GET/POST/DELETE/PUT/PATCH)
    - GET: without create, update or delete on resources
    - POST: create ONLY
    - DELETE:
    - PUT: make sure the target resource already exist then replace the resources by the new resources directly
    - PATCH: make sure the target resource already exist, revise the target object  attributes, not replace
5.
    - exception 係招式


## Spring Boot Project Development



- Create controller folder
    - inside the folder, create interface (XXXOperation.java)
    - create impl folder, create implementation class for the interface
- Create service folder
    - inside the folder, create interface (XXXOperation.java)
    - create impl folder, create implementation class for the interface
- when Contoller @Autowired Service, remember to use service interface, but not implementation class
- test "mvn clean install", already include server starts process