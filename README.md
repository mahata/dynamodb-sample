# What's this?

It's a repository to try out DynamoDB with Kotlin (+ Spring Boot).

## How to run

### Run the app

```
## (only for the first time)
$ mkdir -p docker/dynamodb

$ docker-compose up

## (only for the first time)
$ aws dynamodb create-table \
    --table-name blog-table \
    --attribute-definitions AttributeName=uname,AttributeType=S AttributeName=createdAt,AttributeType=N \
    --key-schema AttributeName=uname,KeyType=HASH AttributeName=createdAt,KeyType=RANGE \
    --billing-mode PAY_PER_REQUEST \
    --endpoint-url http://localhost:7776
```