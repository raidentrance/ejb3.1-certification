# Session beans

##Stateless session beans

* This type of session bean has no conversational state. Whenever a client invokes a method of a stateless EJB, it is as if this or
any other method of the EJB has never been executed. 
* Since no state information is maintained, all stateless EJBs of this type are considered to be equivalent by the EJB container.
* No permanent reference between a client and a stateless EJB is maintained.
