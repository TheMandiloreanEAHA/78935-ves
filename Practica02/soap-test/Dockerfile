FROM erick16/practica02 AS build
EXPOSE 80
EXPOSE 5000
WORKDIR "/app/78935-ves/Practica02/soap-test/" 
RUN dotnet restore
RUN dotnet publish -c Release -o out
FROM erick16/practica02
WORKDIR /app
COPY --from=build /app/78935-ves/Practica02/soap-test/out .
ENTRYPOINT ["dotnet","soap-test.dll"]
