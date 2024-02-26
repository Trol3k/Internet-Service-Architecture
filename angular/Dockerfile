FROM node:latest as build

WORKDIR /usr/local/app

COPY ./ /usr/local/app/

RUN npm install

RUN npm run build



FROM nginx:1.23.3

LABEL authors="Maciej"

ENV API_URL http://localhost:8080/api

EXPOSE 80

COPY --from=build /usr/local/app/dist/angular /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
