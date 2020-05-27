# OAuth2
2019-03 spring boot 2.1.3.RELEASE 기준 으로<br />
spring-security-oauth2-autoconfigure 를 사용한 자체 resource, client 구현<br />
당시 test 용도로 구현하였으며 현재는 Deprecated<br />
모든 테스트는 src > test > http

# 테스트 순서
- login
- getAccountById : login 의 access token 으로 진행.
- renewToken : login 의 refresh token 으로 진행.
