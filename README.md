# mailApp

mailApp is a Java api REST application that exposes a REST API to execute CRUD operations. Replicate the behavior or an email server.

## Run

Use maven [mvn]

```bash
mvn spring-boot:run
```

## Usage

To ADD a new email:

```bash
http://localhost:8081/email/add
```

```json
{
  "from": "dani@gbtech.com",
  "to": [
    {
      "email": "prueba@gbtech.com"
    },
    {
      "email": "prueba2@gbtech.com"
    }
  ],
  "cc": [
    {
      "email": "alguien@gbtech.com"
    }
  ],
  "body": "Hola, esto es una prueba!",
  "estate": "SENT"
}
```

To RECOVER all existing e-mails:
```bash
http://localhost:8081/email/all
```

```json
{
	"id": 1,
	"date": "2022-06-28T19:11:49.000+00:00",
	"from": "dani@gbtech.com",
	"to": [
		  {
			"id": 7,
			"mail": "prueba@gbtech.com"
		},
		  {
			"id": 8,
			"mail": "prueba2@gbtech.com"
		}
	],
	"cc": [
	  {
		"id": 6,
		"mail": "nadie@gbtech.com"
	}
	],
	"body": "Hola, esto es una prueba",
	"state": "SENT"
}
```

To UPDATE an existing email (using their ID):

```bash
http://localhost:8081/email/update/{id}
```

```json
{
  "from": "daniel@gbtech.com",
  "to": [
    {
      "mail": "prueba@gbtech.com"
    }
  ],
  "body": "Hola, esto es una prueba 2",
  "estate": "SENT"
}
```

To DELETE an existing email (using their ID):

```bash
http://localhost:8081/email/delete/{id}
```