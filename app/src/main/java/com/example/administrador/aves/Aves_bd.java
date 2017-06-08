package com.example.administrador.aves;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Clase encargada de crear la base de datos local SQlite con la información de todas las aves
 * Con la propiedad SQLiteOpenHelper se crea una tabla con los parametros de cada ave
 *
 */

public class Aves_bd extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME="AvesBD";
    private static final int DATA_VERSION=1;
    String sqlCreate="CREATE TABLE Aves(codigo INTEGER PRIMARY KEY AUTOINCREMENT,color1 TEXT,color2 TEXT,colorpata TEXT,pico TEXT, forma TEXT, espanol TEXT, ingles TEXT, cientifico TEXT, residencia TEXT, conserva TEXT, link TEXT, rutas TEXT, vistas TEXT )";
    String iniciales="INSERT INTO Aves(color1,color2,colorpata,pico,forma,espanol,ingles,cientifico,residencia,conserva,link,rutas,vistas)VALUES" +

            "('6','8','8','8','0','Zorsal Pico Naranja','Orange-Bellied Nightningale-Trush','Catharus aurantiirostris','1','0','http://www.xeno-canto.org/235614','10','0'),"+
            "('10','6','9','10','8','Cormorán Neotropical','Neotropic Cormorant','Phalacrocorax brasilianus','1','0','http://www.xeno-canto.org/227629','9','0'),"+
            "('3','3','1','10','8','Garcilla Bueyera','Cattle Egret','Bubulcus ibis','1','0','http://www.xeno-canto.org/148199','15','0'),"+
            "('3','3','0','10','8','Garza Real','Great Egret','Ardea alba','1','0','http://www.xeno-canto.org/219024','14','0'),"+
            "('2','6','1','10','8','Garcita Estriada','Striated Heron','Butorides striata','1','0','http://www.xeno-canto.org/327284','10','0'),"+
            "('9','4','1','10','8','Ibis Afeitado O Coquito','Bare-Faced Ibis','Phimosus infuscatus','1','0','http://www.xeno-canto.org/46344','11','0'),"+
            "('4','10','1','6','9','Barraquete Aliazul','Blue-Winged Teal','Anas discors','0','0','http://www.xeno-canto.org/163734','8','0'),"+
            "('9','11','1','1','1','Guala Cabeciroja','Turkey Vulture','Cathartes aura','1','0','http://www.xeno-canto.org/39894','15','0'),"+
            "('9','9','9','1','1','Gallinazo','Black Vulture','Coragyps atratus','1','0','http://www.xeno-canto.org/127221','15','0'),"+
            "('3','6','9','1','1','Aguila Pescadora','Osprey','Pandion haliaetus','0','0','http://www.xeno-canto.org/124926','8','0'),"+
            "('3','6','9','8','0','Pinzon Picofino','Grey-Browed Brush Finch','Arremon assimilis','1','0','http://www.xeno-canto.org/344344','3','0'),"+
            "('4','4','1','1','1','Caracolero Piquiganchudo','Hook-Billed Kite','Chondrohierax uncinatus','1','0','http://www.xeno-canto.org/257345','2','0'),"+
            "('3','6','1','1','1','Elanio Maromero','White-Tailed kite','Elanus leucurus','1','0','http://www.xeno-canto.org/48397','9','0'),"+
            "('3','9','1','1','1','Elanio Enano','Pearl Kite','Gampsonyx swainsonii','1','0','http://www.xeno-canto.org/37116','3','0'),"+
            "('4','6','1','1','1','Gavilán Pollero','Roadside Hawk','Rupornis magnirostris','1','0','http://www.xeno-canto.org/292289','15','0'),"+
            "('4','3','1','1','1','Gavilán Americano','Sharp-Shinned Hawk','Accipiter striatus','1','0','http://www.xeno-canto.org/354364','15','0'),"+
            "('4','3','1','1','1','Gavilan Aliancho','Broad-Winged Hawk','Buteo platypterus','0','0','http://www.xeno-canto.org/353341','15','0'),"+
            "('9','3','1','1','1','Gavilan Colicorto','Short-Tailed Hawk','Buteo brachyurus','1','0','http://www.xeno-canto.org/97291','7','0'),"+
            "('3','6','1','1','1','Gavilán Coliblanco','White-Tailed Hawk','Geranoaetus albicaudatus','1','0','http://www.xeno-canto.org/243822','3','0'),"+
            "('9','3','1','1','1','Gavilan Negro','White-Rumped Hawk','Parabuteo lueucurrhous','1','0','http://www.xeno-canto.org/343838','3','0'),"+
            "('9','4','1','1','1','Águila Poma','Black-And-Chestnut Eagle','Spizaetus isidori','1','1','http://www.xeno-canto.org/252691','7','0'),"+
            "('9','3','1','1','1','Caracara Muñudo','Crested Caracara','Caracara cheriway','1','0','http://www.xeno-canto.org/92403','15','0'),"+
            "('3','4','1','1','1','Pigua','Yellow-Headed Caracara','Milvago chimachima','1','0','http://www.xeno-canto.org/345960','15','0'),"+
            "('4','3','1','1','1','Halcón Reidor','Laughing Falcon','Herpetotheres cachinnans','1','0','http://www.xeno-canto.org/335012','10','0'),"+
            "('4','6','1','1','1','Cernícalo americano','American kestrel','Falco sparverius','1','0','http://www.xeno-canto.org/79761','15','0'),"+
            "('4','4','11','8','10','Guacharaca','Colombian Chachalaca','Ortalis columbiana','1','0','http://www.xeno-canto.org/353890','15','0'),"+
            "('4','12','11','8','10','Pava Maraquera','Sickle-Wnged Guan','Chamaepetes goudotii','1','0','http://www.xeno-canto.org/311822','11','0'),"+
            "('6','4','1','10','10','Rascón Negruzco','Blackish Rail','Pardirallus nigricans','1','0','http://www.xeno-canto.org/315911','8','0'),"+
            "('3','4','11','10','10','Caravana','Southern Lapwing','Vanellus chilensis','1','0','http://www.xeno-canto.org/114069','15','0'),"+
            "('4','3','1','10','10','Agachadiza Noble','Noble Snipe','Gallinago nobilis','1','0','http://www.xeno-canto.org/273811','3','0'),"+
            "('6','3','11','8','7','Paloma Collareja','Band-Tailed Pigeon','Patagioenas fasciata','1','0','http://www.xeno-canto.org/236036','15','0'),"+
            "('7','12','11','8','7','Paloma Colorada','Pale-Vented Pigeon','Patagioenas cayennensis','1','0','http://www.xeno-canto.org/353930','15','0'),"+
            "('4','9','11','8','7','Tortolita','Ruddy Ground Dove','Columbina talpacoti','1','0','http://www.xeno-canto.org/353901','15','0'),"+
            "('4','6','11','8','7','Torcaza Naguiblanca','Eared Dove','Zenaida auriculata','1','0','http://www.xeno-canto.org/299431','15','0'),"+
            "('4','6','11','8','7','Paloma Montaraz Común','White-Tipped Dove','Leptotila verreauxi','1','0','http://www.xeno-canto.org/344308','15','0'),"+
            "('13','11','9','3','4','Cotorra Frentirroja','Scarlet-Fronted Parakeet','Psittacara wagleri','1','0','http://www.xeno-canto.org/312953','11','0'),"+
            "('13','1','9','3','4','Loro Orejiamarillo','Yellow-Eared Parrot','Ognorhynchus icterotis','1','2','http://www.xeno-canto.org/354201','15','0'),"+
            "('13','2','9','3','4','Periquito De Anteojos','Spectacled Parrotlet','Forpus conspicillatus','1','0','http://www.xeno-canto.org/354206','15','0'),"+
            "('13','11','9','3','4','Cotorra Gorriblanca','Speckle-Faced Parrot','Pionus tumultuosus','1','0','http://www.xeno-canto.org/299369','3','0'),"+
            "('7','11','11','3','4','Cotorra Alibronceada O Mocha','Bronze-Winged Parrot','Pionus chalcopterus','1','0','http://www.xeno-canto.org/273655','15','0'),"+
            "('4','3','4','7','10','Cuco Ardilla','Squirrel Cuckoo','Piaya cayana','1','0','http://www.xeno-canto.org/244789','15','0'),"+
            "('9','9','9','10','10','Garrapatero','Smooth-Billed Ani','Crotophaga ani','1','0','http://www.xeno-canto.org/240064','15','0'),"+
            "('3','4','1','1','2','Lechuza común','Barn Owl','Tyto alba','1','0','http://www.xeno-canto.org/313519','11','0'),"+
            "('4','6','9','1','2','Currucutu','Tropical Screech Owl','Megascops choliba','1','0','http://www.xeno-canto.org/265399','15','0'),"+
            "('4','4','9','1','2','Buho Ocelado','Rufous-Banded Owl','strix albitarsis','1','0','http://www.xeno-canto.org/311827','3','0'),"+
            "('12','4','1','1','2','Mochuelo Andino','Andean Pygmy-Owl','Glaucidium jardinii','1','0','http://www.xeno-canto.org/302282','3','0'),"+
            "('6','4','9','7','10','Bienparado Comun','Common Potoo','Nyctibius griseus','1','0','http://www.xeno-canto.org/344325','15','0'),"+
            "('4','4','9','10','10','Chotacabras Pauraque','Common Pauraque','Nyctidromus albicollis','1','0','http://www.xeno-canto.org/344326','11','0'),"+
            "('6','4','9','10','10','Guardacaminos Andino','Band-Winged Nightjar','Caprimulgus longirostris','1','0','http://www.xeno-canto.org/344326','15','0'),"+
            "('4','4','9','10','10','Guardacaminos Lyra','Lyre-Tailed Nightjar','Uropsalis lyra','1','0','http://www.xeno-canto.org/291410','3','0'),"+
            "('9','3','9','10','10','Vencejo Acollarado','White-Collared Swift','Streptoprocne zonaris','1','0','http://www.xeno-canto.org/116378','15','0'),"+
            "('7','2','1','10','8','Garcita Verdosa','Green Heron ','Butorides virescens','0','0','http://www.xeno-canto.org/274175','8','0'),"+
            "('13','4','11','10','6','Ermitaño Verde','Green Hermit','Phaethornis guy','1','0','http://www.xeno-canto.org/128060','15','0'),"+
            "('4','3','9','7','0','Cucarachero Chupoahuevos','Bicolored Wren','Campylorhynchus griseus','1','0','http://www.xeno-canto.org/353887','10','0'),"+
            "('13','5','9','2','3','Colibrí Picolanza Mayor','Green-Fronted Lancebill','Doryfera ludovicae','1','0','http://www.xeno-canto.org/273887','15','0'),"+
            "('13','2','9','2','3','Colibrí Verdemar','Green Violet-Ear','Colibri thalassinus','1','0','http://www.xeno-canto.org/241503','15','0'),"+
            "('10','10','10','10','10','Garrapatero Mayor','Greater Ani','Crotophaga major','1','0','http://www.xeno-canto.org/244941','10','0'),"+
            "('13','2','9','2','3','Colibrí Rutilante','Sparkling Violetear','Colibri coruscans','1','0','http://www.xeno-canto.org/353894','11','0'),"+
            "('10','2','9','2','3','Colibrí Pardo','Brown Violetear','Colibri delphinae','1','0','http://www.xeno-canto.org/344350','2','0'),"+
            "('13','9','9','2','3','Mango Pechinegro','Black-Throated Mango','Anthracothorax nigricollis','1','0','http://www.xeno-canto.org/353891','15','0'),"+
            "('13','13','9','2','3','Esmeralda Occidental','Western Emerald','Chlorostilbon melanorhynchus','1','0','http://www.xeno-canto.org/115488','15','0'),"+
            "('13','3','9','2','3','Esmeralda Andina','Andean Emerald','Amazilia franciae','1','0','http://www.xeno-canto.org/260479','15','0'),"+
            "('13','2','9','2','3','Amazilia Verdiazul','Steely-Vented Hummingbird','Amazilia saucerrottei','1','0','http://www.xeno-canto.org/6392','15','0'),"+
            "('13','12','9','2','3','Amazilia Colirufa','Rufous-Tailed Hummingbird','Amazilia tzacatl','1','0','http://www.xeno-canto.org/271052','15','0'),"+
            "('13','4','11','2','3','Colibrí Pechipunteado','Speckled Hummingbird','Adelomyia melanogenys','1','0','http://www.xeno-canto.org/299428','15','0'),"+
            "('13','4','11','2','3','Brillante Pechigamuza','Fawn-Breasted Brilliant','Heliodoxa rubinoides','1','0','http://www.xeno-canto.org/260497','15','0'),"+
            "('13','4','9','2','3','Brillante Emperador','Empress Brilliant','Heliodoxa imperatrix','1','0','http://www.xeno-canto.org/108952','2','0'),"+
            "('9','12','1','1','1','Halcon Murcielaguero','Bat Falcon','Falco rufigularis','1','1','http://www.xeno-canto.org/338634','10','0'),"+
            "('13','9','9','2','3','Colibrí Aterciopelado','Mountain Velvetbreast','Lafresnaya lafresnayi','1','0','http://www.xeno-canto.org/251033','3','0'),"+
            "('4','3','9','2','3','Inca Bronceado','Bronzy Inca','Coeligena coeligena','1','0','http://www.xeno-canto.org/260504','11','0'),"+
            "('4','7','9','2','3','Inca Pardo','Brown Inca','Coeligena wilsoni','1','0','http://www.xeno-canto.org/275268','2','0'),"+
            "('1','11','9','8','5','Carpintero Pechi Punteado','Spot-Breasted Woodpecker','Colaptes punctigula','1','0','http://www.xeno-canto.org/293810','12','0'),"+
            "('9','3','9','2','3','Inca Acollarado','Collared Inca','Coeligena torquata','1','0','http://www.xeno-canto.org/260506','3','0'),"+
            "('13','4','9','2','3','Colibrí Picoespada','Sword-Billed Hummingbird','Ensifera ensifera','1','0','http://www.xeno-canto.org/260507','3','0'),"+
            "('13','10','9','2','3','Colibrí Colihabano','Buff-Tailed Coronet','Boissonneaua flavescens','1','0','http://www.xeno-canto.org/260508','11','0'),"+
            "('7','9','9','2','3','Colibrí Sietecolores','Velvet-Purple Coronet','Boissonneaua jardini','1','0','http://www.xeno-canto.org/261762','2','0'),"+
            "('13','11','9','2','3','Colibrí Turmalina','Tourmaline Sunangel','Heliangelus exortis','1','0','http://www.xeno-canto.org/117488','11','0'),"+
            "('13','2','9','2','3','Calzadito Reluciente','Glowing Puffleg','Eriocnemis vestita','1','0','http://www.xeno-canto.org/121114','3','0'),"+
            "('13','5','9','2','3','Calzadito Verdoso Norteño','Greenish Puffleg','Haplophaedia aureliae','1','0','http://www.xeno-canto.org/129834','2','0'),"+
            "('13','3','9','2','3','Colibrí de Raquetas','Booted Racket-Tail','Ocreatus underwoodii','1','0','http://www.xeno-canto.org/273648','15','0'),"+
            "('1','6','8','8','0','Reinita Cabecigris','Mourning Warbler','Geothlypis philadelphia','0','0','http://www.xeno-canto.org/353897','14','0'),"+
            "('13','4','9','2','3','Metalura Tiria','Tyrian Metaltail','Metallura tyrianthina','1','0','http://www.xeno-canto.org/353239','3','0'),"+
            "('13','2','9','2','3','Silfo Coliverde','Long-Tailed Sylph','Aglaiocercus kingi','1','0','http://www.xeno-canto.org/275707','15','0'),"+
            "('13','7','9','2','3','Silfo Coliceleste','Violet-Tailed Sylph','Aglaiocercus coelestis','1','0','http://www.xeno-canto.org/264485','2','0'),"+
            "('13','6','9','2','3','Colibrí Piquilargo','Long-Billed Starthroat','Heliomaster longirostris','1','0','http://www.xeno-canto.org/260534','8','0'),"+
            "('13','7','9','2','3','Colibrí De Mitchell','Purple-Throated Woodstar','Calliphlox mitchellii','1','0','http://www.xeno-canto.org/257869','2','0'),"+
            "('13','3','9','2','3','Colibrí De Mulsant','White-Bellied Woodstar','Chaetocercus mulsant','1','0','http://www.xeno-canto.org/260536','15','0'),"+
            "('13','11','11','8','0','Quetzal Cabecidorado','Golden-Headed Quetzal','Pharomachrus auriceps','1','0','http://www.xeno-canto.org/273890','3','0'),"+
            "('13','11','9','8','0','trogon Enmascarado','Masked Trogon','Trogon personatus','1','0','http://www.xeno-canto.org/347842','3','0'),"+
            "('2','12','11','0','0','Martín Pescador Gigante','Ringed kingfisher','Megaceryle torquata','1','0','http://www.xeno-canto.org/56958','9','0'),"+
            "('6','3','9','0','0','Guardacaminos Migratorio','Common Nighthawk','chordeiles minor','0','0','http://www.xeno-canto.org/333896','8','0'),"+
            "('13','3','9','0','0','Martín Pescador Verde','Green Kingfisher','Chloroceryle americana','1','0','http://www.xeno-canto.org/148103','8','0'),"+
            "('13','2','9','7','0','Barranquero','Andean Motmot','Momotus aequatorialis','1','0','http://www.xeno-canto.org/344320','15','0'),"+
            "('4','3','9','6','0','Bigotudo Canoso','Moustached Puffbird','Malacoptila mystacalis','1','0','http://www.xeno-canto.org/354181','14','0'),"+
            "('4','3','9','6','0','Buco Cariblanco','White-Faced Nunbird','Hapaloptila castanea','1','0','http://www.xeno-canto.org/260581','2','0'),"+
            "('13','11','9','6','0','Torito Cabecirrojo','Red-headed Barbet','Eubucco bourcierii','1','0','http://www.xeno-canto.org/344374','15','0'),"+
            "('13','11','9','5','0','Tucaneta Esmeralda','Emerald Toucanet','Aulacorhynchus prasinus','1','0','http://www.xeno-canto.org/98822','15','0'),"+
            "('13','2','9','5','0','Tucaneta Culirroja','Crimson-Rumped Toucanet','Aulacorhynchus haematopygus','1','0','http://www.xeno-canto.org/310770','10','0'),"+
            "('2','3','9','5','0','Terlaque Pechiazul','Black-Billed Mountain Toucan','Andigena nigrirostris','1','1','http://www.xeno-canto.org/344416','3','0'),"+
            "('6','0','9','8','5','Carpinterito Colombiano','Greyish Piculet','Picumnus granadensis','1','0','http://www.xeno-canto.org/354216','10','0'),"+
            "('11','1','9','8','5','Carpintero Carmesi','Crimson-Mantled Woodpecker','Colaptes rivolii','1','0','http://www.xeno-canto.org/130348','3','0'),"+
            "('0','11','9','8','5','Carpintero Oliváceo','Golden-Olive Woodpecker','Colaptes rubiginosus','1','0','http://www.xeno-canto.org/240044','15','0'),"+
            "('9','11','9','8','5','Carpintero Real','Lineated Woodpecker','Dryocopus lineatus','1','0','http://www.xeno-canto.org/48880','15','0'),"+
            "('9','3','9','8','5','Carpintero Bellotero','Acorn Woodpecker','Melanerpes formicivorus','1','0','http://www.xeno-canto.org/57098','15','0'),"+
            "('6','9','9','8','5','Carpintero Habado','Red-Crowned Woodpecker','Melanerpes rubricapillus','1','0','http://www.xeno-canto.org/274160','15','0'),"+
            "('4','11','9','8','5','Carpintero Ahumado','Smoky-Bown Woodpecker','Picoides fumigatus','1','0','http://www.xeno-canto.org/57501','3','0'),"+
            "('9','11','9','8','5','Carpintero Ventriamarillo','Yellow-Vented Woodpecker','Veniliornis dignus','1','0','http://www.xeno-canto.org/51077','3','0'),"+
            "('9','11','9','8','5','Carpintero Gigante','Powerful woodpecker','Campephilus pollens','1','0','http://www.xeno-canto.org/16848','3','0'),"+
            "('4','4','9','7','5','Trepatroncos Tiranino','Tyrannine Woodcreeper','Dendrocincla tyrannina','1','0','http://www.xeno-canto.org/273936','3','0'),"+
            "('6','13','6','8','0','Reinita De Tennessee','Tennessee warbler','Leiothlypis peregrina','0','0','http://www.xeno-canto.org/324186','14','0'),"+
            "('4','3','9','7','5','Trepatroncos Cabecirrayado','Streak-Headed Woodcreeper','Lepidocolaptes souleyetii','1','0','http://www.xeno-canto.org/16771','2','0'),"+
            "('4','3','9','7','5','Trepatroncos Montano','Montane Woodcreeper','Lepidocolaptes lacrymiger','1','0','http://www.xeno-canto.org/276133','3','0'),"+
            "('4','4','9','7','5','Picoguadaña Andino','Brown-Billed scythebill','Campylorhamphus pusillus','1','0','http://www.xeno-canto.org/131806','3','0'),"+
            "('4','6','9','7','0','Piscuis De Azara','Azara´s Spinetail','Synallaxis azarae','1','0','http://www.xeno-canto.org/344361','15','0'),"+
            "('6','3','1','10','8','Martinete Común','Black-Crowned Night Heron','Nycticorax nycticorax','1','0','http://www.xeno-canto.org/226761','8','0'),"+
            "('4','6','9','7','0','Chamicero Palido','Pale-Breasted Spinetail','Synallaxis albescens','1','0','http://www.xeno-canto.org/353740','14','0'),"+
            "('4','3','6','1','2','Búho Rayado','Striped Owl','Pseudoscops clamator','1','0','http://www.xeno-canto.org/144311','8','0'),"+
            "('12','6','11','7','0','Chamicero Rubicundo','Red-Faced Spinetail','Cranioleuca erythrops','1','0','http://www.xeno-canto.org/148271','14','0'),"+
            "('4','3','9','7','5','Trepatroncos Perlado','Pearled Treerunner','Margarornis squamiger','1','0','http://www.xeno-canto.org/273418','3','0'),"+
            "('10','10','10','9','0','Maria Mulata','Great-tailed Grackle','Quiscalus mexicanus','1','0','http://www.xeno-canto.org/56975','12','0'),"+
            "('4','3','9','7','5','Trepatroncos Gorgiblanco','Streaked Tuftedcheek','Pseudocolaptes boissonneautii','1','0','http://www.xeno-canto.org/10764','3','0'),"+
            "('12','6','9','7','5','Hojarasquero Montañero','Montane Foliage-Gleaner','Anabacerthia striaticollis','1','0','http://www.xeno-canto.org/312950','14','0'),"+
            "('4','3','9','7','5','Hojarasquero Grande','Flammulated Treehunter','Thripadectes flammulatus','1','0','http://www.xeno-canto.org/313048','3','0'),"+
            "('4','6','9','7','5','Xenops Estriado','Streaked Xenops','Xenops rutilans','1','0','http://www.xeno-canto.org/234210','11','0'),"+
            "('9','9','9','9','0','Tordo Llanero','Carib Grackle','Quiscalus lugubris','1','0','http://www.xeno-canto.org/245512','0','0'),"+
            "('6','3','9','7','0','Batará Carcajada','Bar-Crested Antshrike','Thamnophilus multistriatus','1','0','http://www.xeno-canto.org/353882','14','0'),"+
            "('1','6','9','0','0','Hormiguero Tiznado','Plain Antvireo','Dysithamnus mentalis','1','0','http://www.xeno-canto.org/273407','14','0'),"+
            "('6','6','9','8','0','Saltator Grisaceo','Grayish Saltator','Saltator coerulescens','1','0','http://www.xeno-canto.org/317798','8','0'),"+
            "('4','6','9','0','0','Hormiguerito Rabilargo','Streak-Headed Antbird','Drymophila striaticeps','1','0','http://www.xeno-canto.org/179738','3','0'),"+
            "('1','1','8','8','0','Reinita Amarilla','Yellow Warbier','Setophaga aestiva','0','0','http://www.xeno-canto.org/302232','10','0'),"+
            "('3','12','9','8','0','Tororoí Comprapan','Chestnut-Crowned Antpitta','Grallaria ruficapilla','1','0','http://www.xeno-canto.org/353248','15','0'),"+
            "('12','6','9','8','0','Tororoí Nuquicastaño','Chestnut-Naped Antpitta','Grallaria nuchalis','1','0','http://www.xeno-canto.org/302276','3','0'),"+
            "('12','12','9','8','0','Tororoí Rufo','Rufous Antpitta','Grallaria rufula','1','0','http://www.xeno-canto.org/353225','3','0'),"+
            "('6','12','9','8','0','Totoroí Enano','Slaty-Crowned Antpitta','Grallaricula nana','1','0','http://www.xeno-canto.org/354324','3','0'),"+
            "('9','11','9','9','0','Soldadito','Red-breasted Blackbird','Sturnella militaris','1','0','http://www.xeno-canto.org/81840','8','0'),"+
            "('6','3','6','8','0','Vireo Ojirrojo','Red-eye Vireo','Vireo olivaceus','1','0','http://www.xeno-canto.org/312941','14','0'),"+
            "('12','9','9','8','0','Tapaculo Ocelado','Ocellated Tapaculo','Acropternis orthonyx','1','0','http://www.xeno-canto.org/301259','3','0'),"+
            "('11','9','11','8','0','Gallito De Roca','Andean Cock-Of-The-Rock','Rupicola peruvianus','1','0','http://www.xeno-canto.org/146364','15','0'),"+
            "('6','11','9','8','0','Cotinga Crestirroja','Red-Crested Cotinga','Ampelion rubrocristatus','1','0','http://www.xeno-canto.org/11217','3','0'),"+
            "('6','12','9','8','0','Cotinga Cresticastaño','Chestnut-Crested Cotinga','Ampelion rufaxilla','1','1','http://www.xeno-canto.org/59259','3','0'),"+
            "('13','9','11','8','0','Frutero Verdinegro','Green-And-Black Fruiteater','Pipreola riefferii','1','0','http://www.xeno-canto.org/354321','11','0'),"+
            "('13','9','9','8','0','Frutero Barrado','Barred Fruiteater','Pipreola arcuata','1','0','http://www.xeno-canto.org/53623','3','0'),"+
            "('6','6','9','7','0','Guardabosques Cenizo','Dusky Piha','Lipaugus fuscocinereus','1','0','http://www.xeno-canto.org/302213','3','0'),"+
            "('1','9','9','8','0','Becard Barrado','Barred Becard','Pachyramphus versicolor','1','0','http://www.xeno-canto.org/92744','3','0'),"+
            "('9','6','9','8','0','Becard Aliblanco','White-Winged Becard','Pachyramphus polychopterus','1','0','http://www.xeno-canto.org/244797','14','0'),"+
            "('1','9','9','8','0','Mosquerito Capirotado','Black-Capped Tyrannulet','Phyllomyias nigrocapillus','1','0','http://www.xeno-canto.org/354116','3','0'),"+
            "('0','1','9','8','0','Mosquerito Caridorado','Golden-Faced Tyrannulet','Zimmerius chrysops','1','0','http://www.xeno-canto.org/353753','15','0'),"+
            "('1','6','9','8','0','Mosquerito Silbón','Southern Beardless Tyrannulet ·','Camptostoma obsoletum','1','0','http://www.xeno-canto.org/344295','12','0'),"+
            "('6','1','9','8','0','Elaenia Copetona','Yellow-Bellied Elaenia','Elaenia flavogaster','1','0','http://www.xeno-canto.org/235741','14','0'),"+
            "('0','6','9','8','0','Elaenia Montañera','Mountain Elaenia','Elaenia frantzii','1','0','http://www.xeno-canto.org/241243','15','0'),"+
            "('0','6','9','8','0','Mosquero Verdoso','Acadian Flycatcher','Empidonax virescens','0','0','http://www.xeno-canto.org/240101','15','0'),"+
            "('4','3','9','8','0','Tiranuelo Gorgiblanco','White-Banded Tyrannulet','Mecocerculus leucophrys','1','0','http://www.xeno-canto.org/356616','3','0'),"+
            "('1','6','9','8','0','Siriri Bueyero','Cattle Tyrant','Machetornis rixosa','1','0','http://www.xeno-canto.org/128386','15','0'),"+
            "('6','0','9','8','0','Tiranuelo Colilargo','White-Banded Tyrannulet','Mecocerculus stictopterus','1','0','http://www.xeno-canto.org/101713','3','0'),"+
            "('6','9','9','8','0','Tiranuelo Saltarroyos','Torrent Tyrannulet','Serpophaga cinerea','1','0','http://www.xeno-canto.org/264679','15','0'),"+
            "('0','6','9','8','0','Atrapamoscas Sepia','Slaty-Capped Flycatcher','Leptopogon superciliaris','1','0','http://www.xeno-canto.org/240093','15','0'),"+
            "('1','12','9','8','0','Atrapamoscas Pechirrufo','Rufous-Breasted Flycatcher','Leptopogon rufipectus','1','0','http://www.xeno-canto.org/354273','11','0'),"+
            "('1','6','9','8','0','Atrapamoscas Marmoreo','Marble-Faced Bristle-Tyrant','Phylloscartes ophthalmicus','1','0','http://www.xeno-canto.org/264686','3','0'),"+
            "('1','6','9','8','0','Atrapamoscas Variegado','Variegated Bristle-Tyrant','Phylloscartes poecilotis','1','0','http://www.xeno-canto.org/131811','3','0'),"+
            "('0','12','9','8','0','Tiranuelo Coronado','Rufous-Crowned Tody-Flycatcher','Poecilotriccus ruficeps','1','0','http://www.xeno-canto.org/101703','3','0'),"+
            "('1','12','9','8','0','Tiranuelo Cabecirrojo','Rufous-Headed Pygmy-Tyrant','Pseudotriccus ruficeps','1','0','http://www.xeno-canto.org/254584','3','0'),"+
            "('1','9','9','8','0','Espatulita Común','Common Tody-Flycatcher','Todirostrum cinereum','1','0','http://www.xeno-canto.org/121450','14','0'),"+
            "('1','6','9','8','0','Picoplano Sulfuroso','Yellow-Olive Flatbill','Tolmomyias sulphurescens','1','0','http://www.xeno-canto.org/14014','10','0'),"+
            "('0','0','9','8','0','Atrapamoscas Amarillento','Flavescent Flycatcher','Myiophobus flavicans','1','0','http://www.xeno-canto.org/347845','3','0'),"+
            "('12','5','9','8','0','Atrapamoscas Pechirayado','Bran-Colored Flycatcher','Myiophobus fasciatus','1','0','http://www.xeno-canto.org/190092','10','0'),"+
            "('12','12','9','8','0','Atrapamoscas Canela','Cinnamon Flycatcher','Pyrrhomyias cinnamomeus','1','0','http://www.xeno-canto.org/357299','11','0'),"+
            "('6','6','9','8','0','Pibí Ahumado','Smoke-Colored Pewee','Contopus fumigatus','1','0','http://www.xeno-canto.org/273865','3','0'),"+
            "('9','3','9','8','0','Atrapamoscas Cuidapuentes','Black Phoebe','Sayornis nigricans','1','0','http://www.xeno-canto.org/264719','15','0'),"+
            "('6','12','9','8','0','Pitajo Pechirrufo','Rufous-Breasted Chat-Tyrant','Ochthoeca rufipectoralis','1','0','http://www.xeno-canto.org/94535','3','0'),"+
            "('12','9','9','8','0','Pitajo Torrentero','Slaty-Backed Chat-Tyrant','Ochthoeca cinnamomeiventris','1','0','http://www.xeno-canto.org/273983','3','0'),"+
            "('0','1','9','8','0','Pitajo Diademado','Yellow-Bellied Chat-Tyrant','Ochthoeca diadema','1','0','http://www.xeno-canto.org/128053','3','0'),"+
            "('4','6','9','8','0','Atrapamoscas Chiflaperros','Streak-Throated Bush Tyrant','Myiotheretes striaticollis','1','0','http://www.xeno-canto.org/236002','3','0'),"+
            "('4','6','9','8','0','Atrapamoscas Tiznado','Smoky Bush Tyrant','Myiotheretes fumigatus','1','0','http://www.xeno-canto.org/273777','3','0'),"+
            "('6','1','9','8','0','Atrapamoscas Montañero','Pale-Edged Flycatcher','Myiarchus cephalotes','1','0','http://www.xeno-canto.org/53387','15','0'),"+
            "('1','4','9','8','0','Bichofue','Great Kiskadee','Pitangus sulphuratus','1','0','http://www.xeno-canto.org/342397','15','0'),"+
            "('1','6','9','8','0','Bienteveo Alicastaño','Rusty-Margined Flycatcher','Myiozetetes cayanensis','1','0','http://www.xeno-canto.org/244839','15','0'),"+
            "('4','1','9','8','0','Siriri Rayado','Streaked Flycatcher','Myiodynastes maculatus','1','0','http://www.xeno-canto.org/235996','13','0'),"+
            "('1','4','9','8','0','Bienteveo Lagartero','Golden-Crowned Flycatcher','Myiodynastes chrysocephalus','1','0','http://www.xeno-canto.org/344376','15','0'),"+
            "('9','3','9','8','0','Siriri Tijereta','Fork-Tailed Flycatcher','Tyrannus savana','1','0','http://www.xeno-canto.org/244972','11','0'),"+
            "('6','1','9','8','0','Siriri Comun','Tropical kingbird','Tyrannus melancholicus','1','0','http://www.xeno-canto.org/320170','15','0'),"+
            "('2','3','9','0','6','Golondrina Azul Y Blanca','Blue-And-White Swallow','Notiochelidon cyanoleuca','1','0','http://www.xeno-canto.org/303953','15','0'),"+
            "('4','6','9','0','6','Golondrina Gorgirrufa','Southern Rough-winged Swallow','Stelgidopteryx ruficollis','1','0','http://www.xeno-canto.org/273745','15','0'),"+
            "('2','9','9','8','0','Urraca Collareja','Black-Collared Jay','Cyanolyca armillata','1','0','http://www.xeno-canto.org/283527','3','0'),"+
            "('9','3','9','8','0','Carriqui Pechiblanco','Black-Chested Jay','Cyanocorax affinis','1','0','http://www.xeno-canto.org/127036','15','0'),"+
            "('13','1','9','8','0','Carriqui Ventriamarillo','Green Jay','Cyanocorax yncas','1','0','http://www.xeno-canto.org/343317','15','0'),"+
            "('9','3','9','8','0','Mirlo-Acuático Coroniblanco','White-Capped Dipper','Cinclus Leucocephalus','1','0','http://www.xeno-canto.org/259247','15','0'),"+
            "('12','12','9','7','0','Cucarachero Rufo','Rufous Wren','Cinnycerthia unirufa','1','0','http://www.xeno-canto.org/356620','3','0'),"+
            "('0','0','9','7','0','Cucarachero Sepia','Sepia-Brown Wren','Cinnycerthia olivascens','1','0','http://www.xeno-canto.org/354114','3','0'),"+
            "('4','6','9','7','0','Cucarachero Comun','House Wren','Troglodytes aedon','1','0','http://www.xeno-canto.org/344337','15','0'),"+
            "('4','6','9','7','0','Cucarachero Montañero','Mountain Wren','Troglodytes solstitialis','1','0','http://www.xeno-canto.org/20474','3','0'),"+
            "('4','6','9','7','0','Cucarachero De Munchique','Munchique Wood Wren','Henicorhina negreti','1','3','http://www.xeno-canto.org/354290','2','0'),"+
            "('4','6','9','7','0','Cucarachero Pechigrís','Grey-Breasted Wood Wren','Henicorhina leucophrys','1','0','http://www.xeno-canto.org/344301','9','0'),"+
            "('4','6','9','7','0','Cucarachero Bigotudo Montano','Whiskered Wren','Pheugopedius mystacalis','1','0','http://www.xeno-canto.org/344378','15','0'),"+
            "('6','6','9','8','0','Sinsonte','Tropical Mockingbird','Mimus gilvus','1','0','http://www.xeno-canto.org/353218','8','0'),"+
            "('4','6','7','8','0','Solitario Andino O Culumpio','Andean Solitaire','Myadestes ralloides','1','0','http://www.xeno-canto.org/354220','15','0'),"+
            "('10','6','9','8','0','Zorzalito De Swainson','Swainson´s Thrush','Catharus ustulatus','0','0','http://www.xeno-canto.org/273829','15','0'),"+
            "('6','8','7','8','0','Mirlo Grande','Great Thrush','Turdus fuscater','1','0','http://www.xeno-canto.org/344362','11','0'),"+
            "('9','8','7','8','0','Mirlo Serrano','Glossy-Black Thrush','Turdus serranus','1','0','http://www.xeno-canto.org/12638','3','0'),"+
            "('6','4','9','8','0','Mayo','Black-Billed Thrush','Turdus ignobilis','1','0','http://www.xeno-canto.org/327535','15','0'),"+
            "('10','6','9','8','0','Zorzal Pardo','Clay-Colored Thrush','Turdus grayi','1','0','http://www.xeno-canto.org/316134','14','0'),"+
            "('0','6','9','8','0','Verderon Piquinegro','Black-Billed Peppershrike','Cyclarhis nigrirostris','1','0','http://www.xeno-canto.org/333542','3','0'),"+
            "('1','4','9','8','0','Vireo Coronipardo','Brown-Capped Vireo','Vireo leucophrys','1','0','http://www.xeno-canto.org/273784','15','0'),"+
            "('9','9','9','9','0','Chamon','Shiny Cowbird','Molothrus bonariensis','1','0','http://www.xeno-canto.org/89345','15','0'),"+
            "('9','9','9','9','0','Chamon Gigante','Giant Cowbird','Molothrus oryzivorus','1','0','http://www.xeno-canto.org/106293','15','0'),"+
            "('4','1','9','9','0','Gulungo','Russet-Backed Oropendola','Psarocolius angustifrons','1','0','http://www.xeno-canto.org/131775','15','0'),"+
            "('9','1','9','9','0','Cacique Montañero','Mountain Cacique','Cacicus chrysonotus','1','0','http://www.xeno-canto.org/310778','3','0'),"+
            "('9','11','9','9','0','Cacique Subtropical','Scarlet-Rumped Cacique','Cacicus uropygialis','1','0','http://www.xeno-canto.org/241461','3','0'),"+
            "('9','11','9','9','0','Cacique Candela','Red-Bellied Grackle','Hypopyrrhus pyrohypogaster','1','2','http://www.xeno-canto.org/74367','15','0'),"+
            "('1','9','9','9','0','Turpial Dorsidorado','Yellow-Backed Oriole','Icterus chrysater','1','0','http://www.xeno-canto.org/235848','15','0'),"+
            "('3','9','9','8','0','Reinita Trepadora','Black-And-White Warbler','Mniotilta varia','0','0','http://www.xeno-canto.org/299440','15','0'),"+
            "('6','1','9','8','0','Reinita Alidorada','Golden-Winged Warbler','Vermivora chrysoptera','1','1','http://www.xeno-canto.org/329965','15','0'),"+
            "('2','1','7','8','0','Reinita Tropical','Tropical Parula','Setophaga pitiayumi','1','0','http://www.xeno-canto.org/327636','15','0'),"+
            "('3','8','9','8','0','Reinita Gorjinaranja','Blackburnian Warbler','Setophaga fusca','0','0','http://www.xeno-canto.org/53620','15','0'),"+
            "('9','1','9','8','0','Candelita Plomiza','Slate-Throated Redstart','Myioborus miniatus','1','0','http://www.xeno-canto.org/235990','15','0'),"+
            "('1','9','9','8','0','Candelita Adornada','Golden-Fronted Whitestart','Myioborus ornatus','1','0','http://www.xeno-canto.org/282400','11','0'),"+
            "('0','1','7','8','0','Reinita Citrina','Citrine Warbler','Myiothlypis luteoviridis','1','0','http://www.xeno-canto.org/341412','3','0'),"+
            "('0','6','9','8','0','Reinita Coronirroja','Russet-Crowned Warbler','Myiothlypis coronatus','1','0','http://www.xeno-canto.org/184784','11','0'),"+
            "('0','6','7','8','0','Reinita Cabecilistada','Three-Striped Warbler','Basileuterus tristriatus','1','0','http://www.xeno-canto.org/353318','11','0'),"+
            "('12','2','9','8','0','Conirrostro Dorsiazul','Blue-Backed Conebill','Conirostrum sitticolor','1','0','http://www.xeno-canto.org/273490','3','0'),"+
            "('9','2','9','8','0','Conirrostro Coronado','Capped Conebill','Conirostrum albifrons','1','0','http://www.xeno-canto.org/22150','3','0'),"+
            "('1','6','9','8','0','Mielerito Comun','Bananaquit','Coereba flaveola','1','0','http://www.xeno-canto.org/347839','15','0'),"+
            "('2','2','9','0','0','Pinchaflor Azulado','Bluish Flowerpiercer','Diglossa Caerulescens','1','0','http://www.xeno-canto.org/278092','1','0'),"+
            "('2','9','9','0','0','Pinchaflor Enmascarado','Masked Flowerpiercer','Diglossa cyanea','1','0','http://www.xeno-canto.org/179735','11','0'),"+
            "('9','3','9','0','0','Pinchaflor Flanquiblanco','White-Sided Flowerpiercer','Diglossa albilatera','1','0','http://www.xeno-canto.org/201041','11','0'),"+
            "('2','9','9','8','0','Mielerito Verde','Green Honeycreeper','Chlorophanes spiza','1','0','http://www.xeno-canto.org/37275','15','0'),"+
            "('13','1','9','8','0','Clorofonia Nuquiazul','Blue-Naped Chlorophonia','Chlorophonia cyanea','1','0','http://www.xeno-canto.org/235634','15','0'),"+
            "('1','2','9','8','0','Eufonia Cabeciazul','Golden-Rumped Euphonia','Euphonia cyanocephala','1','0','http://www.xeno-canto.org/310050','11','0'),"+
            "('1','2','9','8','0','Eufonia Ventrinaranja','Orange-Bellied Euphonia','Euphonia xanthogaster','1','0','http://www.xeno-canto.org/237864','15','0'),"+
            "('1','2','9','8','0','Eufonia Piquigruesa','Thick-billed Euphonia','Euphonia laniirostris','1','0','http://www.xeno-canto.org/273431','15','0'),"+
            "('1','9','9','8','0','Tangara Dorada','Golden Tanager','Tangara arthus','1','0','http://www.xeno-canto.org/354174','15','0'),"+
            "('2','1','9','8','0','Tangara Coronada','Saffron-Crowned Tanager','Tangara xanthocephala','1','0','http://www.xeno-canto.org/106365','11','0'),"+
            "('2','9','9','8','0','Tangara Verdiplata','Metallic-Green Tanager','Tangara labradorides','1','0','http://www.xeno-canto.org/22310','11','0'),"+
            "('2','9','9','8','0','Tangara Real','Blue-Necked Tanager','Tangara cyanicollis','1','0','http://www.xeno-canto.org/296760','11','0'),"+
            "('2','12','9','8','0','Tangara Nuquirrufa','Golden-Naped Tanager','Tangara ruficervix','1','0','http://www.xeno-canto.org/22312','3','0'),"+
            "('13','11','9','8','0','Tangara Cabecibaya','Bay-Headed Tanager','Tangara gyrola','1','0','http://www.xeno-canto.org/353335','15','0'),"+
            "('6','12','9','8','0','Tangara Rastrojera','Scrub Tanager','Tangara vitriolina','1','0','http://www.xeno-canto.org/273700','15','0'),"+
            "('2','9','9','8','0','Tangara De Lentejuelas','Beryl-Spangled Tanager','Tangara nigroviridis','1','0','http://www.xeno-canto.org/354186','11','0'),"+
            "('2','9','9','8','0','Tangara Azulinegra','Blue-And-Black Tanager','Tangara vassorii','1','0','http://www.xeno-canto.org/10768','3','0'),"+
            "('2','9','9','8','0','Tangara Capirotada','Black-Capped Tanager','Tangara heinei','1','0','http://www.xeno-canto.org/245047','15','0'),"+
            "('2','1','9','8','0','Tangara Capiazul','Purplish-Mantled Tanager','Iridosornis porphyrocephalus','1','1','http://www.xeno-canto.org/354185','3','0'),"+
            "('2','1','9','8','0','Tangara Coronidorada','Golden-Crowned Tanager','Iridosornis rufivertex','1','0','http://www.xeno-canto.org/56441','3','0'),"+
            "('2','10','9','8','0','Tangara De Antifaz','Fawn-Breasted Tanager','Pipraeidea melanonota','1','0','http://www.xeno-canto.org/84009','1','0'),"+
            "('1','2','9','8','0','Tangara Lacrimosa','Lacrimose Mountain Tanager','Anisognathus lacrymosus','1','0','http://www.xeno-canto.org/353255','3','0'),"+
            "('1','2','9','8','0','Tangara Primavera','Blue-Winged Mountain Tanager','Anisognathus somptuosus','1','0','http://www.xeno-canto.org/273921','11','0'),"+
            "('1','2','9','8','0','Tangara Montana','Hooded Mountain-Tanager','Buthraupis montana','1','0','http://www.xeno-canto.org/52693','3','0'),"+
            "('1','2','9','8','0','Tangara Diadema','Buff-Breasted Mountain Tanager','Dubusia taeniata','1','0','http://www.xeno-canto.org/354214','3','0'),"+
            "('2','2','9','8','0','Azulejo','Blue-Gray Tanager','Thraupis episcopus','1','0','http://www.xeno-canto.org/245125','15','0'),"+
            "('6','0','9','8','0','Tangara Palmera','Palm Tanager','Thraupis palmarum','1','0','http://www.xeno-canto.org/245423','15','0'),"+
            "('1','2','9','8','0','Tangara Coroniazul','Blue-Capped Tanager','Thraupis cyanocephala','1','0','http://www.xeno-canto.org/12417','3','0'),"+
            "('11','9','9','8','0','Toche Pico De plata','Crimson-Backed Tanager','Ramphocelus dimidiatus','1','0','http://www.xeno-canto.org/354337','15','0'),"+
            "('9','8','9','8','0','Toche','Flame-Rumped Tanager','Ramphocelus flammigerus','1','0','http://www.xeno-canto.org/237855','15','0'),"+
            "('11','11','9','8','0','Piranga Bermeja','Hepatic Tanager','Piranga flava','1','0','http://www.xeno-canto.org/272879','15','0'),"+
            "('11','11','9','8','0','Piranga Roja','Summer Tanager','Piranga rubra','0','0','http://www.xeno-canto.org/298750','15','0'),"+
            "('11','9','9','8','0','Piranga Escarlata','Scarlet Tanager','Piranga olivacea','0','0','http://www.xeno-canto.org/216611','14','0'),"+
            "('1','11','9','8','0','Piranga Capuchirroja','Red-Hooded Tanager','Piranga rubriceps','1','0','http://www.xeno-canto.org/119750','3','0'),"+
            "('11','11','9','8','0','Habia Copetona','Crested Ant Tanager','Habia cristata','1','0','http://www.xeno-canto.org/154861','6','0'),"+
            "('9','9','9','8','0','Tangara Negra','White-Lined Tanager','Tachyphonus rufus','1','0','http://www.xeno-canto.org/263414','15','0'),"+
            "('6','6','9','8','0','Tiranuelo Murino','Mouse-Colored Tyrannulet','Phaeomyias murina','1','0','http://www.xeno-canto.org/273737','9','0'),"+
            "('0','6','9','8','0','Tangara Güirá','Guira Tanager','Hemithraupis guira','1','0','http://www.xeno-canto.org/106374','8','0'),"+
            "('9','11','9','8','0','Pollo De Monte o Rey Del Quindio','White-Capped Tanager','Sericossypha albocristata','1','0','http://www.xeno-canto.org/344360','3','0'),"+
            "('0','6','7','8','0','Tangara Capuchigrís','Grey-Hooded Bush Tanager','Cnemoscopus rubrirostris','1','0','http://www.xeno-canto.org/22318','3','0'),"+
            "('0','9','9','8','0','Hemispingo Capirotado','Black-Capped Hemispingus','Hemispingus atropileus','1','0','http://www.xeno-canto.org/22219','3','0'),"+
            "('13','8','7','8','0','Tangara Lorito','Grass-Green Tanager','Chlorornis riefferii','1','0','http://www.xeno-canto.org/119759','3','0'),"+
            "('2','12','9','8','0','Gorrion Afelpado','Plushcap','Catamblyrhynchus diadema','1','0','http://www.xeno-canto.org/234294','3','0'),"+
            "('0','6','9','8','0','Saltador Ajisero','Buff-Throated Saltator','Saltator maximus','1','0','http://www.xeno-canto.org/273546','2','0'),"+
            "('6','9','9','8','0','Saltador Alinegro','Black-Winged Saltator','Saltator atripennis','1','0','http://www.xeno-canto.org/273684','15','0'),"+
            "('6','0','9','8','0','Saltador Pio Judio','Streaked Saltator','Saltator striatipectus','1','0','http://www.xeno-canto.org/344331','14','0'),"+
            "('3','11','9','8','0','Picogordo Degollado','Rose-Breasted Grosbeak','Pheucticus ludovicianus','0','0','http://www.xeno-canto.org/131800','6','0'),"+
            "('4','9','9','8','0','Gorrion Tangarino','Tanager Finch','Oreothraupis arremonops','1','1','http://www.xeno-canto.org/276313','3','0'),"+
            "('6','1','9','8','0','Atlapetes Gorgiamarillo','White-Naped Brush Finch','Atlapetes albinucha','1','0','http://www.xeno-canto.org/273564','15','0'),"+
            "('6','11','9','8','0','Gorrion Montés Pizarra','Slaty Brush-Finch','Atlapetes schistaceus','1','0','http://www.xeno-canto.org/353249','3','0'),"+
            "('6','12','9','8','0','Gorrion Montés Collarejo','Chestnut-Capped Brush Finch','Arremon brunneinucha','1','0','http://www.xeno-canto.org/273640','15','0'),"+
            "('0','1','9','4','0','Semillero Cariamarillo','Yellow-Faced Grassquit','Tiaris olivaceus','1','0','http://www.xeno-canto.org/273686','15','0'),"+
            "('6','3','9','4','0','Semillero Intermedio','Grey Seedeater','Sporophila intermedia','1','0','http://www.xeno-canto.org/59588','9','0'),"+
            "('9','3','9','4','0','Semillero Negriblanco','Black-And-White Seedeater','Sporophila luctuosa','1','0','http://www.xeno-canto.org/53201','10','0'),"+
            "('9','0','9','4','0','Semillero Capuchino','Yellow-Bellied Seedeater','Sporophila nigricollis','1','0','http://www.xeno-canto.org/273666','15','0'),"+
            "('9','9','9','4','0','Semillero Volatinero','Blue-Black Grassquit','Volatinia jacarina','1','0','http://www.xeno-canto.org/236258','15','0'),"+
            "('6','4','9','4','0','Copetoncito','Rufous-Collared Sparrow','Zonotrichia capensis','1','0','http://www.xeno-canto.org/344379','15','0'),"+
            "('1','6','9','4','0','Boton Se Oro','Saffron Finch','Sicalis flaveola','1','0','http://www.xeno-canto.org/273744','15','0'),"+
            "('1','9','9','4','0','Jilguero Ventriamarillo','Yellow-Bellied Siskin','Spinus xanthogastra','1','0','http://www.xeno-canto.org/273622','1','0'),"+
            "('9','1','9','4','0','Jilguero Menor','Lesser Goldfinch','Spinus psaltria','1','0','http://www.xeno-canto.org/55022','15','0'),"+
            "('6','7','11','0','7','Paloma Comun','Rock Dove','Columba livia','1','0','http://www.xeno-canto.org/257593','12','0')";





    public Aves_bd(Context contexto) {
        super(contexto, DATA_BASE_NAME,null,DATA_VERSION);
    }


    /**
     * Metodo que Inicializa la base de datos
     *
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL(iniciales);

    }

    /**
     * Metodo que actualiza la base de datos
     *
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISITS Usuarios");
        db.execSQL(sqlCreate);

    }




}
