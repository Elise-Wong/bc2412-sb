cd demo-coin-web
mvn clean install -DskipTests
cd ..
cd demo-sb-customer
mvn clean install -DskipTests
cd ..
docker compose build
dockers compose up -d

