# Session beans

##Stateless session beans

* This type of session bean has no conversational state. Whenever a client invokes a method of a stateless EJB, it is as if this or
any other method of the EJB has never been executed. 
* Since no state information is maintained, all stateless EJBs of this type are considered to be equivalent by the EJB container.
* No permanent reference between a client and a stateless EJB is maintained.
* @PostConstruct annotation can be used to designate a method that will be executed before any other methods of the bean are invoked. 
  *  This method is invoked after all of the bean's dependencies have been resolved
*  Before the bean is destroyed, the @PreDestroy annotated method can likewise be used to designate a method to be executed before the bean goes away.
*   Normally, most stateless beans do not require such initialization or termination action.
*   There is no guarantee that the same bean instance will be used for different calls. 
*   Local beans execute in the same JVM as the client,This type of access is typically faster than using remote access which occurs when the client is in a different JVM.
*   When passing or returning an object in a different JVM, the object is passed by value. 
