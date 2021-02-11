# Configuration Snippets


## Subscriptions 

graphql:
  tools:
    schemaLocationPattern: "**/*.graphql"
  servlet:
    mapping: /graphql
    enabled: true
    subscriptions:
      websocket:
        path: /subscriptions


profiles:
    active: reactor 





    graphql:
  tools:
    schemaLocationPattern: "**/*.graphql"
  servlet:
    mapping: /graphql
    enabled: true
    subscriptions:
      websocket:
        path: /subscriptions

## Exceptions 

# Custom Property
route:
  exception: true

graphql:
  servlet:
    exception-handlers-enabled: true

## Security

### DDOS 

graphql:
  servlet:
    graphql.servlet.maxQueryDepth: 100
    graphql.servlet.maxQueryComplexity: 100 
 
 ### Basisc Authentication 
 spring:
  profiles:
    active: security, basic


### OAuth2/JWT 
 spring:
  profiles:
    active: security

## CORS
 corsEnabled: true
    cors:
      allowed-origins: http://some.domain.com


## Actuator
## Actuator Enable GraphQL 
management:
  endpoints: 
    enabled-by-default: true
    web:
      exposure:
        include: "*"