# Message-Driven Beans

A typical message-driven object has the following characteristics:
  
  * Executes upon receipt of a single client message.
  * Is asynchronously invoked.
  * Can be transaction-aware.
  * May update shared data in an underlying database.
  * Does not represent directly shared data in the database, although it may access and update such data.
  * Is relatively short-lived.
  * Is stateless.
  * • Is removed when the EJB container crashes. The container has to re-establish a new message-driven
object to continue computation.

*A typical EJB container provides a scalable runtime environment to execute a large number of message-driven
objects concurrently*
