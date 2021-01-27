import BaseServiceHandler from './BaseServiceHandler';

export default class ContactServices extends BaseServiceHandler {
	constructor() {
		super();
		
		this.contactList = [
			{
				"id": "15128755",
				"firstName": "Walter",
				"lastName": "ATTER",
				"profession": "Maraîcher",
				"socialSecurityNumber": "1984110174056",
				"birthDate": "1984-11-01",
				"birthPlace": "DIEKIRCH",
				"address": {
					"streetAddress1": "15 Allée de la Gare",
					"postalCode": "L-4051",
					"city": "DIEKIRCH"
				}
			},
			{
				"id": "12378352",
				"firstName": "Ingrid",
				"lastName": "IBBEL",
				"profession": "Journaliste",
				"socialSecurityNumber": "1982091898875",
				"birthDate": "1982-09-18",
				"birthPlace": "DIFFERDANGE",
				"address": {
					"streetAddress1": "76 Boulevard de la Gare",
					"postalCode": "L-3861",
					"city": "DIEKIRCH"
				}
			},
			{
				"id": "13320566",
				"firstName": "Ahmed",
				"lastName": "DOQ",
				"profession": "Pharmacien",
				"socialSecurityNumber": "1982042928843",
				"birthDate": "1982-04-29",
				"birthPlace": "GREVENMACHER",
				"address": {
					"streetAddress1": "105 Avenue Grand-Duc Jean",
					"postalCode": "L-9733",
					"city": "DUDELANGE"
				}
			},
			{
				"id": "11909147",
				"firstName": "Hector",
				"lastName": "HOMPU",
				"profession": "Ministre",
				"socialSecurityNumber": "1971072253973",
				"birthDate": "1971-07-22",
				"birthPlace": "CLAIRVAUX",
				"address": {
					"streetAddress1": "33 Esplanade de l'Alzette",
					"postalCode": "L-4061",
					"city": "ESCH-SUR-SURE"
				}
			},
			{
				"id": "19529742",
				"firstName": "Luc",
				"lastName": "SEMBOUR",
				"profession": "Employé de banque",
				"socialSecurityNumber": "1970012660913",
				"birthDate": "1970-01-26",
				"birthPlace": "MERSCH",
				"address": {
					"streetAddress1": "8 Rue Jean Schaack",
					"postalCode": "L-4486",
					"city": "WILTZ"
				}
			},
			{
				"id": "14733070",
				"firstName": "Agathe",
				"lastName": "MWALDO",
				"profession": "Diplomate",
				"socialSecurityNumber": "1976122702509",
				"birthDate": "1976-12-27",
				"birthPlace": "ESCH-SUR-SURE",
				"address": {
					"streetAddress1": "11 Avenue Michel Lentz",
					"postalCode": "L-7866",
					"city": "LUXEMBOURG"
				}
			},
			{
				"id": "12425715",
				"firstName": "Sammy",
				"lastName": "ZEMPLI",
				"profession": "Coiffeur",
				"socialSecurityNumber": "1974062998122",
				"birthDate": "1974-06-29",
				"birthPlace": "ETTELBRUCK",
				"address": {
					"streetAddress1": "143 Rue de la Liberté",
					"postalCode": "L-6493",
					"city": "CLAIRVAUX"
				}
			},
			{
				"id": "16759742",
				"firstName": "Alain",
				"lastName": "TERNETTE",
				"profession": "Administrateur réseau",
				"socialSecurityNumber": "1981102282790",
				"birthDate": "1981-10-22",
				"birthPlace": "PETANGE",
				"address": {
					"streetAddress1": "56 Allée Michel Lentz",
					"postalCode": "L-6503",
					"city": "TROISVIERGES"
				}
			},
			{
				"id": "18266091",
				"firstName": "Sophie",
				"lastName": "LIFORM",
				"profession": "Diététicienne",
				"socialSecurityNumber": "1966090660859",
				"birthDate": "1966-09-06",
				"birthPlace": "ESCH-SUR-ALZETTE",
				"address": {
					"streetAddress1": "157 Allée Princesse Amélie",
					"postalCode": "L-3002",
					"city": "SCHENGEN"
				}
			},
			{
				"id": "12843870",
				"firstName": "Élodie",
				"lastName": "PATOU",
				"profession": "Responsable communication",
				"socialSecurityNumber": "1976100633434",
				"birthDate": "1976-10-06",
				"birthPlace": "ECHTERNACH",
				"address": {
					"streetAddress1": "99 Rue Prince Henri",
					"postalCode": "L-6841",
					"city": "SCHENGEN"
				}
			},
			{
				"id": "12591748",
				"firstName": "Justin",
				"lastName": "TAMAR",
				"profession": "Professeur de musique",
				"socialSecurityNumber": "1976062516211",
				"birthDate": "1976-06-25",
				"birthPlace": "PETANGE",
				"address": {
					"streetAddress1": "106 Place Jean Schaack",
					"postalCode": "L-1207",
					"city": "GREVENMACHER"
				}
			},
			{
				"id": "18202324",
				"firstName": "Julie",
				"lastName": "PATOU",
				"profession": "Écrivain",
				"socialSecurityNumber": "1989112268869",
				"birthDate": "1989-11-22",
				"birthPlace": "VIANDEN",
				"address": {
					"streetAddress1": "14 Allée Grande-Duchesse Charlotte",
					"postalCode": "L-5761",
					"city": "ESCH-SUR-ALZETTE"
				}
			},
			{
				"id": "19774908",
				"firstName": "Omar",
				"lastName": "ITTIM",
				"profession": "Capitaine au long cours",
				"socialSecurityNumber": "1966122514199",
				"birthDate": "1966-12-25",
				"birthPlace": "MONDORF-LES-BAINS",
				"address": {
					"streetAddress1": "35 Rue Claus Cito",
					"postalCode": "L-2020",
					"city": "DIEKIRCH"
				}
			},
			{
				"id": "11735778",
				"firstName": "Brahim",
				"lastName": "IT-HATTEUR",
				"profession": "Comédien",
				"socialSecurityNumber": "1975111684154",
				"birthDate": "1975-11-16",
				"birthPlace": "REDANGE",
				"address": {
					"streetAddress1": "81 Place Edward Steichen",
					"postalCode": "L-4727",
					"city": "CLAIRVAUX"
				}
			},
			{
				"id": "14402692",
				"firstName": "Ahmed",
				"lastName": "SINN",
				"profession": "Chirurgien",
				"socialSecurityNumber": "1982082367964",
				"birthDate": "1982-08-23",
				"birthPlace": "ESCH-SUR-ALZETTE",
				"address": {
					"streetAddress1": "68 Place de la Gare",
					"postalCode": "L-1916",
					"city": "RODANGE"
				}
			},
			{
				"id": "15097398",
				"firstName": "Edouard",
				"lastName": "NENEZ",
				"profession": "Marin-pêcheur",
				"socialSecurityNumber": "1992121518230",
				"birthDate": "1992-12-15",
				"birthPlace": "TROISVIERGES",
				"address": {
					"streetAddress1": "76 Avenue de la Pétrusse",
					"postalCode": "L-8637",
					"city": "ETTELBRUCK"
				}
			},
			{
				"id": "17918414",
				"firstName": "Omar",
				"lastName": "MITON",
				"profession": "Cuisinier",
				"socialSecurityNumber": "1991110812042",
				"birthDate": "1991-11-08",
				"birthPlace": "MERSCH",
				"address": {
					"streetAddress1": "20 Place Prince Henri",
					"postalCode": "L-2434",
					"city": "TROISVIERGES"
				}
			},
			{
				"id": "14085538",
				"firstName": "Rupert",
				"lastName": "TURBEY",
				"profession": "Psychiatre",
				"socialSecurityNumber": "1979012145483",
				"birthDate": "1979-01-21",
				"birthPlace": "LUXEMBOURG",
				"address": {
					"streetAddress1": "12 Place Grand-Duc Jean",
					"postalCode": "L-9208",
					"city": "CLAIRVAUX"
				}
			},
			{
				"id": "19437010",
				"firstName": "Isabelle",
				"lastName": "DENUIT",
				"profession": "Horticultrice",
				"socialSecurityNumber": "1977121241009",
				"birthDate": "1977-12-12",
				"birthPlace": "DIFFERDANGE",
				"address": {
					"streetAddress1": "76 Rue Edward Steichen",
					"postalCode": "L-7261",
					"city": "REDANGE"
				}
			},
			{
				"id": "14004010",
				"firstName": "Henri",
				"lastName": "BOULDINGUE",
				"profession": "Animateur socio-culturel",
				"socialSecurityNumber": "1982062695673",
				"birthDate": "1982-06-26",
				"birthPlace": "REMICH",
				"address": {
					"streetAddress1": "9 Rue Michel Rodange",
					"postalCode": "L-3506",
					"city": "ETTELBRUCK"
				}
			},
			{
				"id": "18485703",
				"firstName": "Alexandre",
				"lastName": "LEGRAND",
				"profession": "Empereur",
				"socialSecurityNumber": "1977040555102",
				"birthDate": "1977-04-05",
				"birthPlace": "SCHENGEN",
				"address": {
					"streetAddress1": "37 Place Prince Henri",
					"postalCode": "L-7243",
					"city": "GREVENMACHER"
				}
			},
			{
				"id": "18539599",
				"firstName": "Thierry",
				"lastName": "GOLOT",
				"profession": "Comédien",
				"socialSecurityNumber": "1976111311726",
				"birthDate": "1976-11-13",
				"birthPlace": "VIANDEN",
				"address": {
					"streetAddress1": "59 Boulevard Grand-Duc Jean",
					"postalCode": "L-3779",
					"city": "WILTZ"
				}
			},
			{
				"id": "14659345",
				"firstName": "Thierry",
				"lastName": "PAILLE",
				"profession": "Restaurateur",
				"socialSecurityNumber": "1973010211472",
				"birthDate": "1973-01-02",
				"birthPlace": "DIFFERDANGE",
				"address": {
					"streetAddress1": "83 Avenue Claus Cito",
					"postalCode": "L-1462",
					"city": "ESCH-SUR-ALZETTE"
				}
			},
			{
				"id": "16242415",
				"firstName": "Igor",
				"lastName": "GONZOLA",
				"profession": "Crémier",
				"socialSecurityNumber": "1973033079405",
				"birthDate": "1973-03-30",
				"birthPlace": "REMICH",
				"address": {
					"streetAddress1": "64 Allée de la Pétrusse",
					"postalCode": "L-9281",
					"city": "DIFFERDANGE"
				}
			},
			{
				"id": "17360159",
				"firstName": "Laurent",
				"lastName": "TABLE",
				"profession": "Gestionnaire de fonds",
				"socialSecurityNumber": "1990102108479",
				"birthDate": "1990-10-21",
				"birthPlace": "MERSCH",
				"address": {
					"streetAddress1": "6 Place du Moulin",
					"postalCode": "L-1824",
					"city": "DIFFERDANGE"
				}
			},
			{
				"id": "19148810",
				"firstName": "Philomène",
				"lastName": "AMBARCQ",
				"profession": "Ingénieur commercial",
				"socialSecurityNumber": "1965011035988",
				"birthDate": "1965-01-10",
				"birthPlace": "RODANGE",
				"address": {
					"streetAddress1": "73 Rue du Moulin",
					"postalCode": "L-7823",
					"city": "STEINFORT"
				}
			},
			{
				"id": "19835452",
				"firstName": "Chantal",
				"lastName": "UNISSON",
				"profession": "Soprano",
				"socialSecurityNumber": "1970012421918",
				"birthDate": "1970-01-24",
				"birthPlace": "REDANGE",
				"address": {
					"streetAddress1": "109 Avenue de la Moselle",
					"postalCode": "L-8133",
					"city": "RODANGE"
				}
			},
			{
				"id": "10348434",
				"firstName": "Alice",
				"lastName": "TERIC",
				"profession": "Infirmière",
				"socialSecurityNumber": "1981031752146",
				"birthDate": "1981-03-17",
				"birthPlace": "PETANGE",
				"address": {
					"streetAddress1": "85 Avenue de la Gare",
					"postalCode": "L-7814",
					"city": "TROISVIERGES"
				}
			},
			{
				"id": "15439069",
				"firstName": "Esther",
				"lastName": "NUET",
				"profession": "Pneumologue",
				"socialSecurityNumber": "1992071045631",
				"birthDate": "1992-07-10",
				"birthPlace": "RODANGE",
				"address": {
					"streetAddress1": "26 Rue de l'Alzette",
					"postalCode": "L-4112",
					"city": "ESCH-SUR-ALZETTE"
				}
			},
			{
				"id": "12819191",
				"firstName": "Ludmila",
				"lastName": "PALTAN",
				"profession": "Transporteur express",
				"socialSecurityNumber": "1977031227661",
				"birthDate": "1977-03-12",
				"birthPlace": "DUDELANGE",
				"address": {
					"streetAddress1": "13 Allée Michel Lentz",
					"postalCode": "L-4590",
					"city": "VIANDEN"
				}
			},
			{
				"id": "11823429",
				"firstName": "Vincent",
				"lastName": "SASSION",
				"profession": "Agent de voyage",
				"socialSecurityNumber": "1968082192124",
				"birthDate": "1968-08-21",
				"birthPlace": "RODANGE",
				"address": {
					"streetAddress1": "102 Place Grand-Duc Jean",
					"postalCode": "L-9988",
					"city": "DIEKIRCH"
				}
			},
			{
				"id": "13645549",
				"firstName": "Gladys",
				"lastName": "SIPLINE",
				"profession": "Éducatrice spécialisée",
				"socialSecurityNumber": "1978052101399",
				"birthDate": "1978-05-21",
				"birthPlace": "SCHENGEN",
				"address": {
					"streetAddress1": "47 Allée Grande-Duchesse Charlotte",
					"postalCode": "L-3992",
					"city": "TROISVIERGES"
				}
			},
			{
				"id": "19840625",
				"firstName": "Henri",
				"lastName": "HOLET",
				"profession": "Pâtissier",
				"socialSecurityNumber": "1993050207600",
				"birthDate": "1993-05-02",
				"birthPlace": "ETTELBRUCK",
				"address": {
					"streetAddress1": "74 Place de la Gare",
					"postalCode": "L-4962",
					"city": "GREVENMACHER"
				}
			},
			{
				"id": "19680903",
				"firstName": "Léonie",
				"lastName": "TOUTENBLOCQ",
				"profession": "Avocate",
				"socialSecurityNumber": "1982082951988",
				"birthDate": "1982-08-29",
				"birthPlace": "RODANGE",
				"address": {
					"streetAddress1": "37 Esplanade Grande-Duchesse Charlotte",
					"postalCode": "L-2311",
					"city": "WILTZ"
				}
			},
			{
				"id": "11265888",
				"firstName": "Rose",
				"lastName": "ASSEE",
				"profession": "Dermatologue",
				"socialSecurityNumber": "1979091527650",
				"birthDate": "1979-09-15",
				"birthPlace": "VIANDEN",
				"address": {
					"streetAddress1": "143 Rue de l'Alzette",
					"postalCode": "L-2634",
					"city": "VIANDEN"
				}
			},
			{
				"id": "10120023",
				"firstName": "Élise",
				"lastName": "TERIA",
				"profession": "Epidémiologiste",
				"socialSecurityNumber": "1974051610884",
				"birthDate": "1974-05-16",
				"birthPlace": "LUXEMBOURG",
				"address": {
					"streetAddress1": "135 Boulevard Edward Steichen",
					"postalCode": "L-5576",
					"city": "GREVENMACHER"
				}
			},
			{
				"id": "18812873",
				"firstName": "Victor",
				"lastName": "PILLET",
				"profession": "Sous-marinier",
				"socialSecurityNumber": "1987091016897",
				"birthDate": "1987-09-10",
				"birthPlace": "SCHENGEN",
				"address": {
					"streetAddress1": "105 Boulevard Grande-Duchesse Charlotte",
					"postalCode": "L-6707",
					"city": "ESCH-SUR-SURE"
				}
			},
			{
				"id": "17192725",
				"firstName": "Jean-Charles",
				"lastName": "HATTAN",
				"profession": "Directeur marketing",
				"socialSecurityNumber": "1986070325987",
				"birthDate": "1986-07-03",
				"birthPlace": "VIANDEN",
				"address": {
					"streetAddress1": "16 Avenue Michel Rodange",
					"postalCode": "L-7309",
					"city": "LUXEMBOURG"
				}
			},
			{
				"id": "14957869",
				"firstName": "Victor",
				"lastName": "PEDOT",
				"profession": "Garagiste",
				"socialSecurityNumber": "1967012542331",
				"birthDate": "1967-01-25",
				"birthPlace": "ETTELBRUCK",
				"address": {
					"streetAddress1": "81 Rue Claus Cito",
					"postalCode": "L-9426",
					"city": "CLAIRVAUX"
				}
			},
			{
				"id": "16022353",
				"firstName": "Arthur",
				"lastName": "PITUDE",
				"profession": "Huissier de justice",
				"socialSecurityNumber": "1972020746906",
				"birthDate": "1972-02-07",
				"birthPlace": "MERSCH",
				"address": {
					"streetAddress1": "23 Boulevard de la Moselle",
					"postalCode": "L-9137",
					"city": "VIANDEN"
				}
			},
			{
				"id": "11031333",
				"firstName": "Alain",
				"lastName": "TRANETTE",
				"profession": "Développeur back-end",
				"socialSecurityNumber": "1974092421659",
				"birthDate": "1974-09-24",
				"birthPlace": "MERSCH",
				"address": {
					"streetAddress1": "10 Rue Edward Steichen",
					"postalCode": "L-6245",
					"city": "ETTELBRUCK"
				}
			},
			{
				"id": "10861414",
				"firstName": "Alex",
				"lastName": "TRANETTE",
				"profession": "Développeur front-end",
				"socialSecurityNumber": "1968101583829",
				"birthDate": "1968-10-15",
				"birthPlace": "ETTELBRUCK",
				"address": {
					"streetAddress1": "66 Esplanade Michel Rodange",
					"postalCode": "L-8496",
					"city": "PETANGE"
				}
			},
			{
				"id": "16081246",
				"firstName": "Alex",
				"lastName": "PLOREUR",
				"profession": "Astronome",
				"socialSecurityNumber": "1995071228934",
				"birthDate": "1995-07-12",
				"birthPlace": "MONDORF-LES-BAINS",
				"address": {
					"streetAddress1": "63 Avenue Jean Schaack",
					"postalCode": "L-1230",
					"city": "RODANGE"
				}
			},
			{
				"id": "11831019",
				"firstName": "Eulalie",
				"lastName": "BIDOT",
				"profession": "Stripteaseuse",
				"socialSecurityNumber": "1968100796122",
				"birthDate": "1968-10-07",
				"birthPlace": "ECHTERNACH",
				"address": {
					"streetAddress1": "11 Allée Claus Cito",
					"postalCode": "L-9857",
					"city": "ECHTERNACH"
				}
			},
			{
				"id": "10502071",
				"firstName": "Ophélie",
				"lastName": "STERIC",
				"profession": "Institutrice",
				"socialSecurityNumber": "1989040703416",
				"birthDate": "1989-04-07",
				"birthPlace": "LUXEMBOURG",
				"address": {
					"streetAddress1": "138 Avenue Grande-Duchesse Charlotte",
					"postalCode": "L-2724",
					"city": "MONDORF-LES-BAINS"
				}
			},
			{
				"id": "13828138",
				"firstName": "Denis",
				"lastName": "LAMERE",
				"profession": "Blanchisseur",
				"socialSecurityNumber": "1973022559346",
				"birthDate": "1973-02-25",
				"birthPlace": "PETANGE",
				"address": {
					"streetAddress1": "55 Avenue de la Liberté",
					"postalCode": "L-5986",
					"city": "PETANGE"
				}
			},
			{
				"id": "10829245",
				"firstName": "Léonard",
				"lastName": "DEVINCI",
				"profession": "Ingénieur",
				"socialSecurityNumber": "1975070841210",
				"birthDate": "1975-07-08",
				"birthPlace": "GREVENMACHER",
				"address": {
					"streetAddress1": "158 Esplanade Prince Henri",
					"postalCode": "L-6077",
					"city": "TROISVIERGES"
				}
			},
			{
				"id": "15014816",
				"firstName": "Léonard",
				"lastName": "TICHO",
				"profession": "Maraîcher",
				"socialSecurityNumber": "1970111422175",
				"birthDate": "1970-11-14",
				"birthPlace": "CLAIRVAUX",
				"address": {
					"streetAddress1": "72 Place Princesse Amélie",
					"postalCode": "L-4321",
					"city": "DUDELANGE"
				}
			},
			{
				"id": "19128819",
				"firstName": "Léonard",
				"lastName": "DEVIVRE",
				"profession": "Décorateur d'intérieur",
				"socialSecurityNumber": "1975010354429",
				"birthDate": "1975-01-03",
				"birthPlace": "ESCH-SUR-SURE",
				"address": {
					"streetAddress1": "55 Allée de l'Alzette",
					"postalCode": "L-2137",
					"city": "DUDELANGE"
				}
			},
			{
				"id": "15418661",
				"firstName": "Laurent",
				"lastName": "SEIGNER",
				"profession": "Agent secret",
				"socialSecurityNumber": "1988122189747",
				"birthDate": "1988-12-21",
				"birthPlace": "STEINFORT",
				"address": {
					"streetAddress1": "76 Allée Princesse Amélie",
					"postalCode": "L-6371",
					"city": "REMICH"
				}
			},
			{
				"id": "18220932",
				"firstName": "Laurent",
				"lastName": "BARRE",
				"profession": "Gestionnaire de patrimoine",
				"socialSecurityNumber": "1973012463631",
				"birthDate": "1973-01-24",
				"birthPlace": "STEINFORT",
				"address": {
					"streetAddress1": "151 Allée Edward Steichen",
					"postalCode": "L-9318",
					"city": "ESCH-SUR-SURE"
				}
			},
			{
				"id": "16193722",
				"firstName": "Laurent",
				"lastName": "TANPLAN",
				"profession": "Éducateur canin",
				"socialSecurityNumber": "1981053092587",
				"birthDate": "1981-05-30",
				"birthPlace": "ECHTERNACH",
				"address": {
					"streetAddress1": "117 Esplanade Prince Henri",
					"postalCode": "L-4684",
					"city": "TROISVIERGES"
				}
			},
			{
				"id": "16763132",
				"firstName": "Laurent",
				"lastName": "TRETAR",
				"profession": "Veilleur de nuit",
				"socialSecurityNumber": "1977092836535",
				"birthDate": "1977-09-28",
				"birthPlace": "GREVENMACHER",
				"address": {
					"streetAddress1": "36 Allée Jean Schaack",
					"postalCode": "L-9418",
					"city": "LUXEMBOURG"
				}
			},
			{
				"id": "16506513",
				"firstName": "Albert",
				"lastName": "LUE",
				"profession": "Opticien",
				"socialSecurityNumber": "1975110132155",
				"birthDate": "1975-11-01",
				"birthPlace": "DIFFERDANGE",
				"address": {
					"streetAddress1": "11 Boulevard Princesse Amélie",
					"postalCode": "L-2382",
					"city": "TROISVIERGES"
				}
			},
			{
				"id": "17627672",
				"firstName": "Sacha",
				"lastName": "TOUILLE",
				"profession": "Ostéopathe",
				"socialSecurityNumber": "1979101297780",
				"birthDate": "1979-10-12",
				"birthPlace": "WILTZ",
				"address": {
					"streetAddress1": "3 Place Prince Henri",
					"postalCode": "L-4855",
					"city": "DIEKIRCH"
				}
			},
			{
				"id": "14091306",
				"firstName": "Alain",
				"lastName": "BAGOT",
				"profession": "Rhumatologue",
				"socialSecurityNumber": "1974032355613",
				"birthDate": "1974-03-23",
				"birthPlace": "ESCH-SUR-ALZETTE",
				"address": {
					"streetAddress1": "138 Place Prince Henri",
					"postalCode": "L-6501",
					"city": "GREVENMACHER"
				}
			},
			{
				"id": "16835653",
				"firstName": "Hervé",
				"lastName": "RITAIT",
				"profession": "Juge d'instruction",
				"socialSecurityNumber": "1990090627611",
				"birthDate": "1990-09-06",
				"birthPlace": "PETANGE",
				"address": {
					"streetAddress1": "127 Allée Grande-Duchesse Charlotte",
					"postalCode": "L-6773",
					"city": "REDANGE"
				}
			},
			{
				"id": "15928020",
				"firstName": "Théophile",
				"lastName": "HAPLON",
				"profession": "Maçon",
				"socialSecurityNumber": "1970062825982",
				"birthDate": "1970-06-28",
				"birthPlace": "MERSCH",
				"address": {
					"streetAddress1": "26 Rue Prince Henri",
					"postalCode": "L-7618",
					"city": "WILTZ"
				}
			},
			{
				"id": "11241891",
				"firstName": "Annie",
				"lastName": "ZETTE",
				"profession": "Restauratrice",
				"socialSecurityNumber": "1976041023213",
				"birthDate": "1976-04-10",
				"birthPlace": "LUXEMBOURG",
				"address": {
					"streetAddress1": "85 Place de la Gare",
					"postalCode": "L-8954",
					"city": "MONDORF-LES-BAINS"
				}
			},
			{
				"id": "16196491",
				"firstName": "Élie",
				"lastName": "ZAI",
				"profession": "Président de la République",
				"socialSecurityNumber": "1992060275751",
				"birthDate": "1992-06-02",
				"birthPlace": "LUXEMBOURG",
				"address": {
					"streetAddress1": "96 Avenue Princesse Amélie",
					"postalCode": "L-5040",
					"city": "DUDELANGE"
				}
			},
			{
				"id": "18020561",
				"firstName": "Rémi",
				"lastName": "FASSOLE",
				"profession": "Compositeur",
				"socialSecurityNumber": "1988060672544",
				"birthDate": "1988-06-06",
				"birthPlace": "TROISVIERGES",
				"address": {
					"streetAddress1": "127 Allée de la Moselle",
					"postalCode": "L-5209",
					"city": "MERSCH"
				}
			},
			{
				"id": "11990235",
				"firstName": "Habib",
				"lastName": "EURDAY-TOUYOU",
				"profession": "Éditeur de cartes de vœux",
				"socialSecurityNumber": "1976071846803",
				"birthDate": "1976-07-18",
				"birthPlace": "DIEKIRCH",
				"address": {
					"streetAddress1": "147 Avenue Michel Rodange",
					"postalCode": "L-9050",
					"city": "RODANGE"
				}
			},
			{
				"id": "13450326",
				"firstName": "Justine",
				"lastName": "HILL-UZION",
				"profession": "Prestidigitatrice",
				"socialSecurityNumber": "1976041152990",
				"birthDate": "1976-04-11",
				"birthPlace": "REMICH",
				"address": {
					"streetAddress1": "89 Allée de l'Alzette",
					"postalCode": "L-6093",
					"city": "ESCH-SUR-ALZETTE"
				}
			}
		];
	}
	
	read(request, response) {
		// ListAll URL: /api/contact
		let result = this.contactList;
		
		if (request.query.id) {
			// GetById URL: /api/contact?id=123456
			result = this.contactList.find(contact => contact.id == request.query.id);
		}
		
		let rc = 200;

		if (!result) {
			rc = 404;
			result = {};
		}
		
		response.status(rc).send(result);
	}
	
	_assign(targetObject, sourceObject) {
		if (!targetObject.address) {
			targetObject.address = {};
		}
		
		this.setObjectProperty(targetObject, "firstName", sourceObject);
		this.setObjectProperty(targetObject, "lastName", sourceObject);
		this.setObjectProperty(targetObject, "profession", sourceObject);
		this.setObjectProperty(targetObject, "socialSecurityNumber", sourceObject);
		this.setObjectProperty(targetObject, "birthDate", sourceObject);
		this.setObjectProperty(targetObject, "birthPlace", sourceObject);
		this.setObjectProperty(targetObject.address, "streetAddress1", sourceObject.address);
		this.setObjectProperty(targetObject.address, "streetAddress2", sourceObject.address);
		this.setObjectProperty(targetObject.address, "postalCode", sourceObject.address);
		this.setObjectProperty(targetObject.address, "city", sourceObject.address);
		this.setObjectProperty(targetObject.address, "country", sourceObject.address);
		
		return targetObject;
	}
	
	create(request, response) {
		let maxid = this.contactList.reduce((max, usr) => usr.id > max ? usr.id : max, 0);
		let newid = maxid + 1;
		this.contactList.push(this._assign({ "id": newid, }, request.body));
		response.status(200).send({ id: newid });
	}
	
	delete(request, response) {
		this.contactList = this.contactList.filter(contact => contact.id != request.query.id);
		response.status(200).send({ id: request.query.id });
	}
	
	update(request, response) {
		let contact = this.contactList.find(ct => ct.id === request.body.id);
		
		if (contact) {
			this._assign(contact, request.body);
			response.status(200).send({ id: request.body.id });
		} else {
			response.status(404).send({});
		}
	}
}
