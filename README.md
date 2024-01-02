Authentification using JWT :
JWT, which stands for JSON Web Token, is a compact, URL-safe means of representing claims between two parties. In the context of Spring Boot or any other web development framework, JWT is often used for authentication and information exchange between parties in a stateless and secure manner.

Here's a brief overview of JWT in the context of Spring Boot:

JSON Web Token (JWT): It is a compact, self-contained way of representing information between two parties. It consists of a header, a payload, and a signature.

Header: The header typically consists of two parts: the type of the token, which is JWT, and the signing algorithm being used, such as HMAC SHA256 or RSA.

Payload: The second part of the token is the payload, which contains the claims. Claims are statements about an entity (typically, the user) and additional data.

Signature: To create the signature part, you take the encoded header, the encoded payload, a secret (or public/private key pair), and the algorithm specified in the header, and sign that.
