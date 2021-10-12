###

#### Rest end point of consumer

http://localhost:9092/movies/

#### To run multiple instances of provider

```bash
java -jar movie-provider/target/movie-provider-0.0.1-SNAPSHOT.jar --server.port=9091 
java -jar movie-provider/target/movie-provider-0.0.1-SNAPSHOT.jar --server.port=9093
```

#### To run instance of consumer

```bash
java -jar movie-consumer/target/movie-consumer-0.0.1-SNAPSHOT.jar --server.port=9092
```