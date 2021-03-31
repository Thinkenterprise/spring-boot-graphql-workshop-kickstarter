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



## Exceptions 

# Custom Property
route:
  exception: true

graphql:
  servlet:
    exception-handlers-enabled: true

## Security


 
### Basisc Authentication 
 spring:
  profiles:
    active: security, basic


### OAuth2/JWT 
 spring:
  profiles:
    active: security
    
  security:
    oauth2:
      resourceserver:
        jwt: 
          public-key-location: public-key.txt
          

## CORS
 corsEnabled: true
    cors:
      allowed-origins: http://some.domain.com

### DDOS 

graphql:
  servlet:
    maxQueryDepth: 100
    maxQueryComplexity: 100 
    
## Actuator
 
management:
  endpoints: 
    enabled-by-default: true
    web:
      exposure:
        include: "*"
        
## Actuator Enable GraphQL
   tracingEnabled: true
   actuator-metrics: true
        