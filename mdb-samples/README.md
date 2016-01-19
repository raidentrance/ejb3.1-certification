# Message-Driven Beans

  A Message-Driven Bean (MDB) implements business logic in an asynchronous fashion. The client does not receive a response to the message from the MDB. A client will send a message to a queue or topic.  The message is then retrieved and processed by the MDB.

  A queue differs from a topic in that a message in a queue is sent to a single MDB. In contrast, a message in a topic will be sent to each MDB that is registered with that topic. From the client's perspective, the MDB is anonymous. There is no way for the client to identify or otherwise select a specific MDB.


A typical message-driven object has the following characteristics:
  
  * MDBs are managed by the server EJB container. 
  * The EJB container will treat all instances of the same MDB class identically
  * A message will be delivered to the next available instance of the MDB.
  * The container will create and destroy MDBs as necessary. 
  *  While an MDB has no conversational state, instance variables in an MDB may hold information needed to work correctly. This can include database connection and references to other EJBs.
  * An MDB may use a MessageDrivenContext to obtain information regarding the server's EJB container. This interface is based on the EJBContext interface that deals with transaction and security issues among other things.
  * Executes upon receipt of a single client message.
  * Is asynchronously invoked.
  * Can be transaction-aware.
  * Is stateless.
  * Is removed when the EJB container crashes. The container has to re-establish a new message-driven object to continue computation.
  * if a client sends out multiple messages to the server containing an MDB, there is no guarantee the same MDB instance will be used for each message or that the messages will be processed in the same order the client sent them. 


*A typical EJB container provides a scalable runtime environment to execute a large number of message-driven
objects concurrently*

The creation of an MDB involves three tasks:

* Using the @MessageDriven annotation to designate the class as an MDB.
* Implementing the javax.jms.MessageListener interface for JMS-driven beans.
* Overriding the onMessage method.
* @PostConstruct and @PreDestroy annotations are supported.

The MDB must be defined as public and **cannot be declared as final or abstract**. In addition, it needs a public default constructor and **cannot have a finalize method**.

The javax.jms.MessageListener interface has a single method, **onMessage**. This method is passed a javax.jms.Message object. Five sub-interfaces exist based on the Message interface:

* TextMessage – A Java String object
* BytesMessage – An unformatted stream of bytes
* StreamMessage – A stream of bytes based on primitive Java data types
* MapMessage – A set of key/value pairs
* ObjectMessage – Contains a Java object

When a message is sent to the onMessage method, the message is cast to one of these interface types and processed.

There are two common techniques for structuring an MDB application:
* Point-to-Point – One or more producers will send messages to a queue. These messages are then consumed by one or more consumers (MDBs). Once removed from a queue it is no longer available to other consumers.
* Publish/Subscribe – One or more producers will send messages to a topic. Each message in the topic will then be sent to each consumer (MDB) that is currently subscribing to the topic.
