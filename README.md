# Spring Boot

## SpringBoot + ElasticSearch

RUN ElasticSearch Daemon

	./elasticsearch-2.4.4/bin/elasticsearch.bat

	-OR-

	./elasticsearch-2.4.4/bin/elasticsearch -d

POSTMAN:

	POST http://127.0.0.1:9094/api/city
	{
		"id":"1",
		"provinceid":"1",
		"cityname":"Guangzhou",
		"description":"广州是个好地方"
	}

	POST http://127.0.0.1:9094/api/city
	{
		"id":"2",
		"provinceid":"1",
		"cityname":"Foshan",
		"description":"Neighbor of Guangzhou"
	}

http://localhost:9094/api/city/search?pageNumber=0&pageSize=10&searchContent=Guangzhou

## SpringBoot + FreeMarker

http://localhost:9095/api/city
http://localhost:9095/api/city/1

## Spring Boot Central Exception Handlers + ThymeLeaf

http://localhost:9150
http://localhost:9150/hello
http://localhost:9150/json