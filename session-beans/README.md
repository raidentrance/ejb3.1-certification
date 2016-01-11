# Session beans

A typical session object has the following characteristics:

* Executes on behalf of a single client.
* Can be transaction-aware.
* Updates shared data in an underlying database.
* Does not represent directly shared data in the database, although it may access and update such data.
* Is relatively short-lived.
* Is removed when the EJB container crashes. The client has to re-establish a new session object to continue computation.

A typical EJB container provides a scalable runtime environment to execute a large number of session
objects concurrently.

The EJB specification defines **stateful**, **stateless**, and **singleton** session beans.


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
*   Better scalability is desired.
*   Better performance is desired. No need to maintain state and multiple instances being available to server requests gives
better performance.
* All business object references of the same interface type for the same stateless session bean have the
same object identity, which is assigned by the container. All references to the no-interface view of the
same stateless session bean have the same object identity. 

<pre>
 <code>
       @EJB Cart cart1;
       @EJB Cart cart2;
       ...
       if (cart1.equals(cart1)) { // this test must return true
        ...
       }
       ...
       if (cart1.equals(cart2)) { // this test must also return true
        ...
       }
 </code>
</pre>
* The equals method always returns true when used to compare references to the same business interface
type of the same stateless session bean. 



##Stateful session beans
* The EJB needs to retain state related to a client across multiple method invocations.
* A stateful session object has a unique identity that is assigned by the container at the time the object is created. A client of the stateful session bean business interface can determine if two business interface or no-interface view references refer to the same session object by use of the equals method.
<pre><code>
@EJB Cart cart1;
@EJB Cart cart2;
...
if (cart1.equals(cart1)) { // this test must return true
 ...
}
...
if (cart1.equals(cart2)) { // this test must return false
 ...
}
</code></pre>
* All stateful session bean references to the same business interface for the same stateful session bean
instance will be equal. 


##Singleton session beans
* Some state needs to be shared throughout the application.
* One single EJB is to be accessed by multiple threads concurrently
* Useful to perform startup or shutdown task(s)
* All business object references of the same interface type for the same singleton session bean have the same object identity, which is assigned by the container. All references to the no-interface view of the same singleton session bean have the same object identity. 
<pre><code>
@EJB Shared shared1;
@EJB Shared shared2;
...
if (shared1.equals(shared1)) { // this test must return true
 ...
}
...
if (shared1.equals(shared2)) { // this test must also return true
 ...
}

</code></code>
* The equals method always returns true when used to compare references to the same business interface
type of the same singleton session bean. 










