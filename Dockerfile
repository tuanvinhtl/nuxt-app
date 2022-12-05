FROM node:16.3.0-alpine as builder

# Create app directory
WORKDIR /usr/src/app
ENV PATH /usr/src/app/node_modules/.bin:$PATH

# Install app dependencies
# A wildcard is used to ensure both package.json AND package-lock.json are copied
# where available (npm@5+)
COPY package*.json ./

# If you are building your code for production
# RUN npm install --only=production
RUN npm install
#RUN npm install acorn-dynamic-import --save-dev
# Bundle app source
COPY . .
RUN npm run build
ENV HOST 0.0.0.0
ENV PORT 3000
EXPOSE 3000
CMD [ "npm", "start" ]