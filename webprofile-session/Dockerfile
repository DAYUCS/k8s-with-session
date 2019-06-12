FROM open-liberty:webProfile8-java8-openj9

COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/bootstrap.properties /config
COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/server.env /config
COPY --chown=1001:0 target/liberty/wlp/usr/servers/defaultServer/hazelcast.jar /config
COPY --chown=1001:0 src/main/liberty/config/server.xml /config
COPY --chown=1001:0 src/main/liberty/config/hazelcast-config.xml /config
COPY --chown=1001:0 target/*.war /config/apps/webprofile-session.war