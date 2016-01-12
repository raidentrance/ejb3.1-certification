# ejb3.1-certification 


Java EE 6 Enterprise JavaBeans Developer Certified Expert
1Z0-895

## Enterprise Java Beans
Enterprise JavaBeans is an architecture for component-based transaction-oriented enterprise applications.

## Enterprise Java Beans Roles 

The Enterprise JavaBeans architecture defines seven distinct roles in the application development and
deployment life cycle.

* Enterprise Bean Provider

  The Enterprise Bean Provider (Bean Provider) is the producer of enterprise beans. His or her output is an **ejb-jar** file that contains one or more enterprise beans. The Enterprise Bean Provider is typically an application domain expert. The Bean Provider develops reusable enterprise beans that typically implement business tasks or business entities.

  The Bean Provider is not required to be an expert at system-level programming. Therefore, the Bean
Provider usually does not program transactions, concurrency, security, distribution, or other services
into the enterprise beans. The Bean Provider relies on the EJB container for these services.
A Bean Provider of multiple enterprise beans often performs the EJB Role of the **Application Assembler**.

* Application Assembler

  The Application Assembler combines enterprise beans into larger deployable application units. The input to the Application Assembler is one or more ejb-jar files produced by the Bean Provider(s). The Application Assembler outputs one or more ejb-jar files that contain the enterprise beans along with their application assembly instructions. 

  The Application Assembler can also combine enterprise beans with other types of application components
when composing an application.

  *The Application Assembler is a domain expert who composes applications that use enterprise beans.
The Application Assembler works with the enterprise bean’s metadata annotations and/or deployment
descriptor and the enterprise bean’s client-view contract. Although the Assembler must be familiar with
the functionality provided by the enterprise bean’s client-view interfaces, he or she does not need to
have any knowledge of the enterprise bean’s implementation.*

* Deployer

  The Deployer takes one or more ejb-jar files produced by a Bean Provider or Application Assembler and deploys the enterprise beans contained in the ejb-jar files in a specific operational environment. The operational environment includes a specific EJB server and container.
  
  The Deployer must resolve all the external dependencies declared by the Bean Provider, and must follow the application assembly instructions defined by the Application Assembler. To perform his or her role, the Deployer uses tools provided by the EJB Container Provider.
  
  The Deployer’s output is a set of enterprise beans (or an assembled application that includes enterprise beans) that have been customized for the target operational environment, and that are deployed in a specific EJB container.
  
  The Deployer is an expert at a specific operational environment and is responsible for the deployment of enterprise beans. For example, the Deployer is responsible for mapping the security roles defined by the Bean Provider or Application Assembler to the user groups and accounts that exist in the operational environment in which the enterprise beans are deployed.
  
  * The Deployer uses tools supplied by the EJB Container Provider to perform the deployment tasks. The
deployment process is typically two-stage: The Deployer first generates the additional classes and interfaces that enable the container to manage the enterprise beans at runtime. These classes are container-specific.
  * The Deployer performs the actual installation of the enterprise beans and the additional classes and interfaces into the EJB container
  
* EJB Server Provider

  The EJB Server Provider is a specialist in the area of distributed transaction management, distributed objects, and other lower-level system-level services. A typical EJB Server Provider is an OS vendor, middleware vendor, or database vendor. The current EJB architecture assumes that the EJB Server Provider and the EJB Container Provider roles are the same vendor. Therefore, it does not define any interface requirements for the EJB Server Provider.

* EJB Container Provider

  The EJB Container Provider (Container Provider for short) provides: 
    * The deployment tools necessary for the deployment of enterprise beans.
    * The runtime support for the deployed enterprise bean instances. 

* Persistence Provider

  The expertise of the Persistence Provider is in object/relational mapping, query processing, and caching. The focus of the Persistence Provider is on the development of a scalable, transaction-enabled runtime environment for the management of persistence.
  
* System Administrator

  The System Administrator is responsible for the configuration and administration of the enterprise’s computing and networking infrastructure that includes the EJB server and container. The System Administrator is also responsible for overseeing the well-being of the deployed enterprise beans applications at runtime.
  






  
  
  
