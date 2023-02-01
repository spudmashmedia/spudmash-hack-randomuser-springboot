#---------------------------------------------------------------------------------------------
#  Copyright (c) Spudmash Media Pty Ltd
#  Licensed under the MIT License. See License.txt in the project root for license information.
#---------------------------------------------------------------------------------------------

FROM node:18-alpine as builder
WORKDIR /usr/src/app
COPY src ./src
COPY public ./public
COPY package.json ./
COPY tailwind.config.js ./
COPY postcss.config.js ./
COPY vite.config.js ./
COPY index.html ./
RUN npm i
RUN npm run build

#
# Copy out folder from builder and host with nginx
#
FROM nginx:1-alpine
COPY --from=builder /usr/src/app/dist /usr/share/nginx/html
