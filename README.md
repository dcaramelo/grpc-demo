# grpc-demo

Proto generation :
```
<PATCH_BIN_PROTOC>/protoc --java_out=src/main/java/ src/main/java/context/proto/context.proto 
```

*NB: protoc executable is available in this repo "protoc-3.2.0-osx-x86_64.zip"*

RUN docker with the server:
```
docker build -t grpc-bench-server .
docker run -p 50052:50052 -p 5000:5000 grpc-bench-server
```

RUN the client:
```
cd src/node
node client-grpc-simple.js
```
