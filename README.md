# shopey

For POST accept should be text/plain
both application/json and application/x-www-form-urlencoded is allowed as Content-Type


for GET
Accept: application/json  or application/xml


For basic Authontication format is "Basic user:password";
tried to use base64 but while testing string comparison fails and auth fails all the time.
user name and password are hard coded in web app, so use "Basic rinshad:iloveindia" as Authorization
