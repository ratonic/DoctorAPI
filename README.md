[Medicos.postman_collection.json](https://github.com/user-attachments/files/20306801/Medicos.postman_collection.json)
🚀 Características
Registro de Médicos: Permite añadir nuevos médicos con sus datos relevantes (nombre, email, especialidad, teléfono).
Consulta de Médicos: Posibilita obtener la lista de todos los médicos registrados o buscar un médico específico por su ID.
Actualización de Datos de Médicos: Permite modificar la información de un médico existente.
Eliminación de Médicos: Permite borrar un registro de médico de la base de datos.
Validación de Datos: Asegura la integridad de los datos de entrada para los médicos.
Persistencia de Datos: Utiliza una base de datos MySQL para el almacenamiento persistente de la información.
🛠️ Tecnologías Utilizadas
Para el desarrollo y ejecución de este proyecto, se han utilizado las siguientes tecnologías:

Spring Boot: Framework para el desarrollo de aplicaciones Java, facilitando la creación de APIs RESTful.
Java 21: Versión del lenguaje de programación Java en la que está construido el proyecto.
MySQL: Sistema de gestión de bases de datos relacionales utilizado para la persistencia de datos.
Spring Data JPA: Abstracción para simplificar el acceso a datos y la implementación de repositorios con JPA y Hibernate.
Maven: Herramienta de automatización de construcción y gestión de dependencias.
Lombok: Librería que reduce el código boilerplate en las clases Java.
MapStruct: Generador de código para mapeos de objetos tipo DTO a Entidad y viceversa.
🚀 Despliegue en Railway
Esta API está diseñada para ser desplegada fácilmente en plataformas como Railway, aprovechando sus servicios de base de datos gestionados y variables de entorno.





[Uploa{
	"info": {
		"_postman_id": "2c028f7a-0e67-42ad-8788-ae277bd4086d",
		"name": "Medicos",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "34355708"
	},
	"item": [
		{
			"name": "Obtener Medico",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://doctorapi-production-2d4b.up.railway.app/doctores",
					"protocol": "http",
					"host": [
						"doctorapi-production-2d4b",
						"up",
						"railway",
						"app"
					],
					"path": [
						"doctores"
					]
				}
			},
			"response": []
		},
		{
			"name": "Obtener Medico Por Especialidad",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://doctorapi-production-2d4b.up.railway.app/doctores/especialidad/cardiologia",
					"protocol": "http",
					"host": [
						"doctorapi-production-2d4b",
						"up",
						"railway",
						"app"
					],
					"path": [
						"doctores",
						"especialidad",
						"cardiologia"
					]
				}
			},
			"response": []
		},
		{
			"name": "Obtener medico disponible",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://doctorapi-production-2d4b.up.railway.app/doctores/disponibles?fecha=2024-03-20",
					"protocol": "http",
					"host": [
						"doctorapi-production-2d4b",
						"up",
						"railway",
						"app"
					],
					"path": [
						"doctores",
						"disponibles"
					],
					"query": [
						{
							"key": "fecha",
							"value": "2024-03-20"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Obtener medico disponible por especialidad",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://doctorapi-production-2d4b.up.railway.app/doctores/disponibles/especialidad/ginecologia?fecha=2024-03-20",
					"protocol": "http",
					"host": [
						"doctorapi-production-2d4b",
						"up",
						"railway",
						"app"
					],
					"path": [
						"doctores",
						"disponibles",
						"especialidad",
						"ginecologia"
					],
					"query": [
						{
							"key": "fecha",
							"value": "2024-03-20"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Obtener medico disponible por ID",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://doctorapi-production-2d4b.up.railway.app/doctores/disponibles/doctor/1?fecha=2024-03-20",
					"protocol": "http",
					"host": [
						"doctorapi-production-2d4b",
						"up",
						"railway",
						"app"
					],
					"path": [
						"doctores",
						"disponibles",
						"doctor",
						"1"
					],
					"query": [
						{
							"key": "fecha",
							"value": "2024-03-20"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Obtener Medico por ID",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://doctorapi-production-2d4b.up.railway.app/doctores/2",
					"protocol": "http",
					"host": [
						"doctorapi-production-2d4b",
						"up",
						"railway",
						"app"
					],
					"path": [
						"doctores",
						"2"
					]
				}
			},
			"response": []
		},
		{
			"name": "Añadir medico",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"name\": \"Nelson Chavez\",\r\n    \"specialty\": \"Cardiologo\",\r\n    \"email\": \"nelsonchavez@gmail.com\",\r\n    \"phone\": \"3333333332\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://doctorapi-production-2d4b.up.railway.app/doctores",
					"protocol": "http",
					"host": [
						"doctorapi-production-2d4b",
						"up",
						"railway",
						"app"
					],
					"path": [
						"doctores"
					]
				}
			},
			"response": []
		},
		{
			"name": "Editar Medico",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"name\": \"Omar Fabian Acosta\",\r\n    \"specialty\": \"cardiologo\",\r\n    \"email\": \"omar@gmail.com\",\r\n    \"phone\": \"3012971389\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://doctorapi-production-2d4b.up.railway.app/doctores/1",
					"protocol": "http",
					"host": [
						"doctorapi-production-2d4b",
						"up",
						"railway",
						"app"
					],
					"path": [
						"doctores",
						"1"
					]
				}
			},
			"response": []
		}
	]
}ding Medicos.postman_collection.json…]()
