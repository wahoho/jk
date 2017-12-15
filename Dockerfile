FROM debian:wheezy

MAINTAINER Jason Yap

RUN apt-get update && \
    apt-get install -y less emacs git wget gcc libpcre3 libpcre3-dev zlib1g-dev make libssl-dev

WORKDIR /root
RUN wget http://nginx.org/download/nginx-1.9.10.tar.gz && \
    tar xvf nginx-1.9.10.tar.gz && \
    git clone https://takayuki-hayashi@bitbucket.org/nginx-goodies/nginx-sticky-module-ng.git

WORKDIR /root/nginx-1.9.10
RUN ./configure --add-module=/root/nginx-sticky-module-ng && \
    make && \
    make install && \
    mkdir /var/log/nginx/

ADD nginx/nginx.conf /usr/local/nginx/conf/nginx.conf
ADD nginx/default.conf /etc/nginx/conf.d/default.conf
ADD nginx/start-nginx.sh /opt/start-nginx.sh
RUN chmod +x /opt/start-nginx.sh

# Install Node.js and other dependencies
WORKDIR /var/html

ADD dev .

EXPOSE 8999
ENTRYPOINT ["/opt/start-nginx.sh"]