FROM openjdk:8
ADD /target/service-credit-account-0.0.1-SNAPSHOT.jar service-credit-account.jar 
EXPOSE 8074
CMD ["java","-jar","service-credit-account.jar"]  
