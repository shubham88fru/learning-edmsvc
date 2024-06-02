# learning-edmsvc

- SAGA Design pattern is primarily used in scenarios of distributed transaction across microservices.The SAGA Design pattern is a way to manage data consistency across microservices in distributed transaction scenrios. There are two ways to implement SAGA Design pattern:
	1. Choreography based SAGA
	2. Orchestration based SAGA

- Choreography based SAGA:
	In choreography based SAGA, each microservice process an event
	and  publishes another event in response, that triggers and action
	in another microservice an action in another microservice. When a 
	particular service fails to process and event, the entire transaction
	needs to be rolledback, and so it spits out an event that triggers
	other services to perform reverse actions (a.k.a compensating transaction)

- Orchestration based SAGA:
	In this pattern, the microservices, in addition to other bussiness classes, also
	have a SAGA class that acts as an orchestrator of commands/events that need to be sent.
	The SAGA class keep emitting events one by one based on the current state to acheive the 
	end goal.
