
## Query queries


### Query routes 
schema {
	query: Query
}

type Query { 
	routes: [Route]
}

type Route {
	id: ID!
	flightNumber: String!
	departure: String
	destination: String
	isDisabled: Boolean	
}

## Query route
type Query { 
	routes: [Route]
	route(flightNumber: String!): Route
}

## Query releations

type Route {
	id: ID!
	flightNumber: String!
	departure: String
	destination: String
	isDisabled: Boolean	
    flights: [Flight!]
	route: Route	
}


type Flight {
	id: ID!
	price: Float!
	route: Route!
	discount: Float!
}

## Query inheriance 

interface Employee {
	id: ID!
	staffNumber: String!
	lastName: String! 
	firstName: String! 
	role: EmployeRole!
}

type Pilot implements Employee {
	id: ID!
	staffNumber: String!
	lastName: String! 
	firstName: String! 
	role: EmployeRole!
	certificateNumber: String 
}

enum EmployeRole {
	PILOT
	ATTENDANT
}



## Query Mutation Create, Delete, Update

schema {
	query: Query
	mutation: Mutation
}


type Mutation {
	createRoute(flightNumber: String!): Route
    updateRoute(id: ID!, departure: String!): Route
	deleteRoute(id: ID!): Boolean
	updateRouteWithRouteInput(id: ID!, routeInput: RouteInput) : Route
	
}

## QuerySubscription 

type Subscription {
    registerRouteCreated: Route 
}

schema {
	query: Query
	mutation: Mutation
	subscription: Subscription
}


## Query Custom Data Types

scalar LocalDate


type Flight {
	id: ID!
	price: Float!
	route: Route!
	employees: [Employee!]
	date: LocalDate!
	discount: Float!
}