# Simple-Kafka (Development Stage)
Simple-Kafka aims to provide a much simpler java API with implementation for producer and Consumer. So that people with little knowledge of Apache Kafka can easily integrate this real time messaging system into their projects.

# Key Features 

1 : Simpler Java Producer API with implementation and functionality can be extended on user need basis.

2 : Simpler Java Consumer API with implementation and functionality can be extended on user need basis.

3 : A Web console to Monitor the messaging system.


## How to create producer using simple-kafka
To create a kafka producer using simple-kafka is a much easier process, all we need to do is.
<code>
* **KafakaProducerService kafkaPropducerService = ProducerFactory.getProducerService();**
* **Producer< String > producer = kafkaPropducerService.getProducer();** 
</code>

In above example we are creating a producer that can send String data based on default configuration as specified by user on jar creation.

### KafakaProducerService
KafakaProducerService provides services through which we can create a custom producer based on our need as well as we can also send data of any type given we have its encoder and decoder class with us.

####KafakaProducerService API Info
We have good documentation in our code through which we can easily understand this API as well as anyone can also expand this API as per need.

####KafakaProducerService API Methods to create kafka Producer
1. **Producer< String  > getProducer()** 
2. **List< Producer< String > > getProducers(int numOfProducer)** 
3. **< T > Producer< T > getProducer(Class< ? extends Encoder< T > > clazz)**
4. **< T > List< Producer< T > > getProducers(int numOfProducer, Class< ? extends Encoder< T > > clazz)** 
6. **List< Producer< String > > getProducers(int numOfProducer, Properties producerProps)** 
7. **< T > Producer< T > getProducer(Properties producerProps, Class< ? extends Encoder< T > > clazz)** 
8. **< T > List<Producer< T > > getProducers(int numOfProducer, Properties producerProps, Class< ? extends Encoder< T > > clazz)** 


Any help would be appreciated :)
