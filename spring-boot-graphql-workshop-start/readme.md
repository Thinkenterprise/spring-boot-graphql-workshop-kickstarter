# Workshop


## First Session

### GraphQL 
 
- [Homepage](https://graphql.org)
- [Client-Directed Queries](https://www.thoughtworks.com/radar/techniques/client-directed-query)
- Advantages if (many clients an many views, autonomous teams, performance)
- [Specification](http://spec.graphql.org/June2018/)
- [Reference Implementation](https://github.com/graphql)
- [Book Learning GraphQL](https://www.amazon.de/-/en/Eve-Porcello/dp/1492030716/ref=sr_1_6?dchild=1&keywords=GraphQL&qid=1612195189&sr=8-6)
- [Book GraphQL](https://www.amazon.de/s?i=stripbooks&rh=p_27%3ADominik+Kress&s=relevancerank&language=en&text=Dominik+Kress&ref=dp_byline_sr_book_1)



### GraphQL Java   
- [Homepage](https://www.graphql-java.com)
- [Github](https://github.com/graphql-java/graphql-java)



### GraphQL Tools, Servlet & Spring Boot  

- [Homepage](https://graphql-java-kickstart.com/) 
- [Github](https://github.com/graphql-java/graphql-java-spring) 

### GraphQL Alternative Spring Boot Frameworks 
- [Marek](https://github.com/graphql-java/graphql-java-spring) 
- [Netflix](https://github.com/Netflix/dgs-frameworkg) 

### GraphQL Type System 

Modelling your GraphQL API in the Backend 

- [Visual Design GraphQL](https://www.amazon.de/-/en/Thomas-Frisendal/dp/1484239032/ref=sr_1_1?dchild=1&keywords=Visual+Design+GraphQL&qid=1612195438&sr=8-1)


#### Contract-First 
- [Schema](http://spec.graphql.org/June2018/#sec-Schema)
- [GraphQL API Schema Design](https://www.amazon.de/-/en/Matthias-Biehl-ebook/dp/B079D4938K/ref=sr_1_3?dchild=1&keywords=API+Design+GraphQL&qid=1612195502&sr=8-3)
- [Schema Best Practice](https://github.com/artsy/README/blob/master/playbooks/graphql-schema-design.md)
- [Schema Principles](https://principledgraphql.com)
- [Schema Stitching](https://www.youtube.com/watch?v=AAkSdyi_vIA)
- [Directives](https://www.graphql-java.com/documentation/v11/sdl-directives/)
- [AWS Schema Stitching](https://www.youtube.com/results?search_query=AWS+Directives+GraphQL)
- [GraphQL Code Generators](https://graphql-code-generator.com/docs/getting-started/index)
- [Open API](https://openapi-generator.tech/docs/generators/graphql-schema/)

#### Code-First 
- [Annotations](https://github.com/Enigmatis/graphql-java-annotations)
- [Programmatisch](https://www.graphql-java.com/documentation/v16/schema/)


### GraphQL Query Language 

Call the API from the Client 
 
- [Specification](https://spec.graphql.org/June2018/#sec-Language)
- [Apollo](https://www.apollographql.com)
- [Relay](https://relay.dev)


## Second Session 


## GraphQL Spring Boot Application & Base Configuration 

- Show the Maven Dependencies ``pom.xml`` 
- Show Schema File ``api-graphql`` 
- Show the Application ``GraphQlSpringBootApplication`` 
- Show the Application Configuration ``application.yaml`` 
- Start the Application 
- [GraphiQL](http://localhost:4000/graphiql)
- [Playground](http://localhost:4000/playground)
- [Altair](http://localhost:4000/altair)
- [Voyager](http://localhost:4000/voyager)




## GraphQL Resolvers 

###  Query 

Code Snippets under **query ... **

First test with ``curl-query-sample.sh`` an show Postman Body use -d content of scipt.

- Model, Implement & Test **all routes** over root resolver ``RootQueryResolver`` 

The other tests with ``query-*.graphql h`` 

- Model, Implement & Test **one routes** over root resolver ``RootQueryResolver`` 
- Model, Implement & Test ** Relation**  over object resolver ``RouteQueryResolver``
- Model, Implement & Test ** Inheritance** resolver ``RouteQueryResolver``

 ** Issue: Install Postman Plugin for GraphQL **


### Mutation 

Code Snippets under **mutation ... **

- Model, Implement & Test ** Create, Update, Delete** resolver ``RouteMutationResolver`` 


The other tests with ``mutation-*.graphql`` 

show changes in database over h2 console http://localhost:4000/h2-console



### Subscriptions 

Code Snippets under **subscriptions ... **

- GraphQL Web Socket **Configuration** 
- **Dependencies** for Reactive Stream Implementation 
- **Implement** `` ProjectReactorRouteSubscriptionNotifier`` 
- **Bean Configuration** `` GraphqlConfiguration`` 
- Model Subscriptions
- **Implement**  ``RoutSubscriptionResolver`` 
- **Implement Notifying**  ``RoutMutationnResolver`` 
- **Test**  ``RoutMutationnResolver`` 



## Custom Types 

Code Snippets under **custom ... **

- [Alexey Zhokhov](https://www.zhokhov.com)
- [Alexey Zhokhov Github](https://github.com/donbeave/graphql-java-datetime)
- [GraphQL Extended Data Types](https://github.com/graphql-java/graphql-java-extended-scalars)
- Show How to implement your own scala types 

- **Dependencies** includes Autoconfiguration !! 
- **Modelling**
- **Test** 


## GraphQL Validation  
- [Bean Validation Directives](https://github.com/graphql-java/graphql-java-extended-validation)
- [Bean Validation](https://beanvalidation.org/2.0/spec/)
- Show **Dependencies** 
- Add Annotations @NotBlank Route Input 
- Add @Validated to ``RoutMutationnResolver`` 
- Add @Valid to Parameter 



## GraphQL Exception 

Code Snippets under **exceptions ... **

- [Errors and Results](https://www.youtube.com/watch?v=RDNTP66oY2o) - 4:53, 6:16 , 7:55 , 9:30 
- [GraphQL Errors Specification](http://spec.graphql.org/June2018/#sec-Errors)
- **Implement** Custom GraphQL Error `` CustomGraphQLError`` 
- **Implement** Exception Handler  
- **Configuration Properties** Enableing & GraphQL Exception Handler Enabling   
- **test**


** Issue: Use GraphQLErrorBuilder **
** Issue: Handle BeanValidationException **

## GraphQL Test 
Code Snippets under **test ... **

- **Dependency** Show the GraphQL Test Starter & Spring Boot Test Starter 
- **Implement** `` GraphQLQueryTest.java`` **Attention missing $ Code Snippet**


**Issue: Decide is it other tests to**


## GraphQL Security 

Code Snippets under **security ... **


### Basic Authentication 
Basic Authentification over HTTP Standard 

- **Dependency** Security Starter and show Connection Problems 
- **Implement** No Security Configuration ``GraphQLNoSecurityConfiguration`` ``@Configuration`` ``@Profile("!security")``
- **Implement** Basic Security ``GraphQLBasicWebSecurityConfiguration`` ``@Configuration`` ``@Profile("basic")`` and configure profile 
- **Implement** Method Based Security ``@PreAuthorize("hasRole('read')")`` ``RootQueryResolver`` 
- **Implement** Enable Method Based Security ``@EnableGlobalMethodSecurity(prePostEnabled=true)`` ``GraphQLBasicMethodSecurityConfiguration.java`` 
- **Test** with ``curl-security-basic-sample.sh``

** Issue How to set User an Password over Playground in the header**


### OAuth2 / JWT 
Token based Securtiy 
- **Dependency**  
- **Configuration** Profile 
- **Configuration** PKI Public Certification 
- **Implement** Method Based Security ``@PreAuthorize("hasAuthority('SCOPE_read')")`` ``RootQueryResolver`` 
- **Test** with ``curl-security-token-sample.sh``

### CORS 
**Cross-origin resource sharing**
- **Configuration** ``corsEnabled: true`` ``cors:allowed-origins: http://some.domain.come``
- **Test** with additional Header ``-H "Origin: http://some.domain.come"``

** Issue CORS allowed origins does'nt work**

### DDOS
**Denial-of-service attack**
- [DDOS](https://en.wikipedia.org/wiki/Denial-of-service_attack)
- [AWS](https://d1.awsstatic.com/whitepapers/Security/DDoS_White_Paper.pdf)
- [GraphQL](https://www.howtographql.com/advanced/4-security)

- **Configuration**  `` graphql.servlet.maxQueryDepth: 100``  `` graphql.servlet.maxQueryComplexity: 100``  


** Issue DDSO Parameter does'nt work**


## GraphQL Context
Code Snippets under **context ... **

For each request set your GraphQL Context to use it in your resolvers 

- **Implement** a Custom Context with your Data ``CustomGraphQLServletContext implements GraphQLServletContext`` 
- **Implement** a Custom Context Builder ``CustomGraphQLServletContextBuilder implements GraphQLServletContextBuilder`` 
- **Implement Configuration** ``GraphQLConfiguration``
- **Implement Context Access** and explain ``DataFetchingEnvironment``
- **Test** with additional Header ``-H "user-id: Michael"``


## GraphQL Performance 

### Asynchrone 

Code Snippets under **async ... **

- **Implement** Change in ``RootQueryResolver`` the ``CompletableFuture<Route> route(String flightNumber)`` signature 
- **Test** Only thats work ... 


### Caching & Batch Loading 

The problem is that every field is read regardless of whether it has already been read. The solution is to read all data once, to cache and then to make it available via the cache. 

Code Snippets under **cache ... **

- **Model** show ``discount`` in Schema an Java 
- **Implement** discount in ``FlightQueryResolver`` 
- **Test** with Playground and show ``query-cache.graphql`` with multiple access 
- **Implements** ``DiscountBatchLoader`` from ``BatchLoader<Long, Float>`` 
- **Implements** ``CustomGraphQLServletContextBuilder`` add create Data Loader Factory 
- **Implements** Access to Data Loader ...  


## GraphQL Metrics 

- [Actuator](spring boot actuator)
- **Dependency** Show Spring Boot Actuator Starter 
- **Test** Start and Show General Metrics 
- **Configuration** Enable Metrics `` tracingEnabled: true`` ``actuator-metrics: true`` 
- **Test** Start and Show GraphQL Metrics 

 
  
  
  
  
  