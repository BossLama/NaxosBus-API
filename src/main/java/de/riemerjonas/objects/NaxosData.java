package de.riemerjonas.objects;

import de.riemerjonas.other.SystemMessage;

public class NaxosData {


    public static void initConnections() {
        //LOAD CONNECTIONS LINE 1
        BusNetwork.getBusStop("Naxos Town / Port").createConnection(1, 5, BusNetwork.getBusStop("Municipal Parking"));
        BusNetwork.getBusStop("Municipal Parking").createConnection(1, 5, BusNetwork.getBusStop("Elli's Park"));
        BusNetwork.getBusStop("Elli's Park").createConnection(1, 5, BusNetwork.getBusStop("National Bank"));
        BusNetwork.getBusStop("National Bank").createConnection(1, 5, BusNetwork.getBusStop("Cinema Naxos"));
        BusNetwork.getBusStop("Cinema Naxos").createConnection(1, 5, BusNetwork.getBusStop("Princess Hotel"));
        BusNetwork.getBusStop("Princess Hotel").createConnection(1, 5, BusNetwork.getBusStop("Naxos Camping"));
        BusNetwork.getBusStop("Naxos Camping").createConnection(1, 5, BusNetwork.getBusStop("Naxos Palace"));
        BusNetwork.getBusStop("Naxos Palace").createConnection(1, 5, BusNetwork.getBusStop("Lagos Mare"));
        BusNetwork.getBusStop("Lagos Mare").createConnection(1, 5, BusNetwork.getBusStop("Gas Station"));
        BusNetwork.getBusStop("Gas Station").createConnection(1, 5, BusNetwork.getBusStop("Agios Prokopios"));
        BusNetwork.getBusStop("Agios Prokopios").createConnection(1, 5, BusNetwork.getBusStop("Agia Anna 1st"));
        BusNetwork.getBusStop("Agia Anna 1st").createConnection(1, 5, BusNetwork.getBusStop("Agia Anna Parking"));
        BusNetwork.getBusStop("Agia Anna Parking").createConnection(1, 5, BusNetwork.getBusStop("Agia Anna Port"));
        BusNetwork.getBusStop("Agia Anna Port").createConnection(1, 5, BusNetwork.getBusStop("Paradise Restaurant"));
        BusNetwork.getBusStop("Paradise Restaurant").createConnection(1, 5, BusNetwork.getBusStop("Maragas"));
        BusNetwork.getBusStop("Maragas").createConnection(1, 5, BusNetwork.getBusStop("Italika"));
        BusNetwork.getBusStop("Italika").createConnection(1, 5, BusNetwork.getBusStop("Plaka Voula"));
        BusNetwork.getBusStop("Plaka Voula").createConnection(1, 5, BusNetwork.getBusStop("Placafe / Aegean"));
        BusNetwork.getBusStop("Placafe / Aegean").createConnection(1, 5, BusNetwork.getBusStop("Three Brothers"));
        BusNetwork.getBusStop("Three Brothers").createConnection(1, 5, BusNetwork.getBusStop("Dolphin"));
        BusNetwork.getBusStop("Dolphin").createConnection(1, 5, BusNetwork.getBusStop("Plaka Camping"));
        BusNetwork.getBusStop("Plaka Camping").createConnection(1, 5, BusNetwork.getBusStop("Petrino"));
        BusNetwork.getBusStop("Petrino").createConnection(1, 5, BusNetwork.getBusStop("Plaza Hotel"));
        BusNetwork.getBusStop("Plaza Hotel").createConnection(1, 5, BusNetwork.getBusStop("Orkos Beach"));
        BusNetwork.getBusStop("Orkos Beach").createConnection(1, 5, BusNetwork.getBusStop("Parthena Beach"));
        BusNetwork.getBusStop("Parthena Beach").createConnection(1, 5, BusNetwork.getBusStop("Mikri Vigla Konthos"));
        BusNetwork.getBusStop("Mikri Vigla Konthos").createConnection(1, 5, BusNetwork.getBusStop("Mikri Vigla Beach"));

        //LOAD CONNECTIONS ROUTE 2
        BusNetwork.getBusStop("Naxos Town / Port").createConnection(2, 5, BusNetwork.getBusStop("Hospital"));
        BusNetwork.getBusStop("Hospital").createConnection(2, 5, BusNetwork.getBusStop("Vallindra"));
        BusNetwork.getBusStop("Vallindra").createConnection(2, 5, BusNetwork.getBusStop("Galanado"));
        BusNetwork.getBusStop("Galanado").createConnection(2, 5, BusNetwork.getBusStop("Kato Sagri"));
        BusNetwork.getBusStop("Kato Sagri").createConnection(2, 5, BusNetwork.getBusStop("Sagkri"));
        BusNetwork.getBusStop("Sagkri").createConnection(2, 5, BusNetwork.getBusStop("Damalas"));
        BusNetwork.getBusStop("Damalas").createConnection(2, 5, BusNetwork.getBusStop("Damarionas"));
        BusNetwork.getBusStop("Damarionas").createConnection(2, 5, BusNetwork.getBusStop("Halki Church"));
        BusNetwork.getBusStop("Halki Church").createConnection(2, 5, BusNetwork.getBusStop("Halki"));
        BusNetwork.getBusStop("Halki").createConnection(2, 5, BusNetwork.getBusStop("Kaloxylos"));
        BusNetwork.getBusStop("Kaloxylos").createConnection(2, 5, BusNetwork.getBusStop("Kerami"));
        BusNetwork.getBusStop("Kerami").createConnection(2, 5, BusNetwork.getBusStop("Filoti Platanos"));
        BusNetwork.getBusStop("Filoti Platanos").createConnection(2, 5, BusNetwork.getBusStop("Filoti Velaki"));
        BusNetwork.getBusStop("Filoti Velaki").createConnection(2, 5, BusNetwork.getBusStop("Apiranthos"));
        BusNetwork.getBusStop("Apiranthos").createConnection(2, 5, BusNetwork.getBusStop("Stavros Keramotis"));
        BusNetwork.getBusStop("Stavros Keramotis").createConnection(2, 5, BusNetwork.getBusStop("Argokili Crossroad"));
        BusNetwork.getBusStop("Argokili Crossroad").createConnection(2, 5, BusNetwork.getBusStop("Lionas Crossroad"));
        BusNetwork.getBusStop("Lionas Crossroad").createConnection(2, 5, BusNetwork.getBusStop("Koronos"));
        BusNetwork.getBusStop("Koronos").createConnection(2, 5, BusNetwork.getBusStop("Skado"));
        BusNetwork.getBusStop("Skado").createConnection(2, 5, BusNetwork.getBusStop("Skado Seladi"));
        BusNetwork.getBusStop("Skado Seladi").createConnection(2, 5, BusNetwork.getBusStop("Komiaki"));
        BusNetwork.getBusStop("Komiaki").createConnection(2, 5, BusNetwork.getBusStop("Apollonas Kouros"));
        BusNetwork.getBusStop("Apollonas Kouros").createConnection(2, 5, BusNetwork.getBusStop("Apollonas"));
        BusNetwork.getBusStop("Apollonas").createConnection(2, 5, BusNetwork.getBusStop("Apiranthos"));
        BusNetwork.getBusStop("Apiranthos").createConnection(2, 5, BusNetwork.getBusStop("Azalas"));
        BusNetwork.getBusStop("Azalas").createConnection(2, 5, BusNetwork.getBusStop("Moutsouna Volakas"));
        BusNetwork.getBusStop("Moutsouna Volakas").createConnection(2, 5, BusNetwork.getBusStop("Moutsouna - Port"));

        //LOAD CONNECTIONS ROUTE 3
        BusNetwork.getBusStop("Naxos Town / Port").createConnection(3, 5, BusNetwork.getBusStop("Hospital"));
        BusNetwork.getBusStop("Hospital").createConnection(3, 5, BusNetwork.getBusStop("Vallindra"));
        BusNetwork.getBusStop("Vallindra").createConnection(3, 5, BusNetwork.getBusStop("Galanado Tzanini"));
        BusNetwork.getBusStop("Galanado Tzanini").createConnection(3, 5, BusNetwork.getBusStop("Glinado Church"));
        BusNetwork.getBusStop("Glinado Church").createConnection(3, 5, BusNetwork.getBusStop("Glinado"));
        BusNetwork.getBusStop("Glinado").createConnection(3, 5, BusNetwork.getBusStop("Agios Arsenios"));
        BusNetwork.getBusStop("Agios Arsenios").createConnection(3, 5, BusNetwork.getBusStop("Vivlos Church"));
        BusNetwork.getBusStop("Vivlos Church").createConnection(3, 5, BusNetwork.getBusStop("Vivlos"));
        BusNetwork.getBusStop("Vivlos").createConnection(3, 5, BusNetwork.getBusStop("Vivlos Banikos"));
        BusNetwork.getBusStop("Vivlos Banikos").createConnection(3, 5, BusNetwork.getBusStop("Camp"));
        BusNetwork.getBusStop("Camp").createConnection(3, 5, BusNetwork.getBusStop("Agia Paraskevi"));
        BusNetwork.getBusStop("Agia Paraskevi").createConnection(3, 5, BusNetwork.getBusStop("Mikri Vigla"));
        BusNetwork.getBusStop("Mikri Vigla").createConnection(3, 5, BusNetwork.getBusStop("Stratouris"));
        BusNetwork.getBusStop("Stratouris").createConnection(3, 5, BusNetwork.getBusStop("Mikri Vigla"));
        BusNetwork.getBusStop("Mikri Vigla").createConnection(3, 5, BusNetwork.getBusStop("Kastraki Beach"));
        BusNetwork.getBusStop("Kastraki Beach").createConnection(3, 5, BusNetwork.getBusStop("Kastraki Apolafsi"));
        BusNetwork.getBusStop("Kastraki Apolafsi").createConnection(3, 5, BusNetwork.getBusStop("Glyfada"));
        BusNetwork.getBusStop("Glyfada").createConnection(3, 5, BusNetwork.getBusStop("Alyko Faros"));
        BusNetwork.getBusStop("Alyko Faros").createConnection(3, 5, BusNetwork.getBusStop("Alyko"));
        BusNetwork.getBusStop("Alyko").createConnection(3, 5, BusNetwork.getBusStop("Pyrgaki Finikas"));
        BusNetwork.getBusStop("Pyrgaki Finikas").createConnection(3, 5, BusNetwork.getBusStop("Pyrgaki Kottakis"));
        BusNetwork.getBusStop("Pyrgaki Kottakis").createConnection(3, 5, BusNetwork.getBusStop("Pyrgaki"));

        //LOAD LINE 4
        BusNetwork.getBusStop("Naxos Town / Port").createConnection(4, 5, BusNetwork.getBusStop("Hospital"));
        BusNetwork.getBusStop("Hospital").createConnection(4, 5, BusNetwork.getBusStop("Vallindra"));
        BusNetwork.getBusStop("Vallindra").createConnection(4, 5, BusNetwork.getBusStop("Agios Thalellaios"));
        BusNetwork.getBusStop("Agios Thalellaios").createConnection(4, 5, BusNetwork.getBusStop("Melanes"));
        BusNetwork.getBusStop("Melanes").createConnection(4, 5, BusNetwork.getBusStop("Kourounohori"));
        BusNetwork.getBusStop("Kourounohori").createConnection(4, 5, BusNetwork.getBusStop("Miloi"));
        //BusNetwork.getBusStop("Miloi").createConnection(4, 5, BusNetwork.getBusStop("Kouros Melanes"));
        BusNetwork.getBusStop("Miloi").createConnection(4, 5, BusNetwork.getBusStop("Kinidaros"));

        //LOAD LINE 5
        BusNetwork.getBusStop("Naxos Town / Port").createConnection(5, 5, BusNetwork.getBusStop("Municipal Parking"));
        BusNetwork.getBusStop("Municipal Parking").createConnection(5, 5, BusNetwork.getBusStop("Galini"));
        BusNetwork.getBusStop("Galini").createConnection(5, 5, BusNetwork.getBusStop("Eggares"));
        BusNetwork.getBusStop("Eggares").createConnection(5, 5, BusNetwork.getBusStop("Moni Faneromenis"));
        BusNetwork.getBusStop("Moni Faneromenis").createConnection(5, 5, BusNetwork.getBusStop("Hilia Vrysi"));
        BusNetwork.getBusStop("Hilia Vrysi").createConnection(5, 5, BusNetwork.getBusStop("Kampos Komiakis"));
        BusNetwork.getBusStop("Kampos Komiakis").createConnection(5, 5, BusNetwork.getBusStop("Abram"));
        BusNetwork.getBusStop("Abram").createConnection(5, 5, BusNetwork.getBusStop("Agioi Theodoroi"));
        BusNetwork.getBusStop("Agioi Theodoroi").createConnection(5, 5, BusNetwork.getBusStop("Agia"));
        BusNetwork.getBusStop("Agia").createConnection(5, 5, BusNetwork.getBusStop("Kouros Apollona"));
        BusNetwork.getBusStop("Kouros Apollona").createConnection(5, 5, BusNetwork.getBusStop("Apollonas Port"));

        //LOAD LINE 6
        BusNetwork.getBusStop("Naxos Town / Port").createConnection(6, 5, BusNetwork.getBusStop("Hospital"));
        BusNetwork.getBusStop("Hospital").createConnection(6, 5, BusNetwork.getBusStop("Vallindra"));
        BusNetwork.getBusStop("Vallindra").createConnection(6, 5, BusNetwork.getBusStop("Galanado"));
        BusNetwork.getBusStop("Galanado").createConnection(6, 5, BusNetwork.getBusStop("Kato Sagri"));
        BusNetwork.getBusStop("Kato Sagri").createConnection(6, 5, BusNetwork.getBusStop("Sagkri"));
        BusNetwork.getBusStop("Sagkri").createConnection(6, 5, BusNetwork.getBusStop("Damalas"));
        BusNetwork.getBusStop("Damalas").createConnection(6, 5, BusNetwork.getBusStop("Damarionas"));
        BusNetwork.getBusStop("Damarionas").createConnection(6, 5, BusNetwork.getBusStop("Halki Church"));
        BusNetwork.getBusStop("Halki Church").createConnection(6, 5, BusNetwork.getBusStop("Halki"));
        BusNetwork.getBusStop("Halki").createConnection(6, 5, BusNetwork.getBusStop("Kaloxylos"));
        BusNetwork.getBusStop("Kaloxylos").createConnection(6, 5, BusNetwork.getBusStop("Kerami"));
        BusNetwork.getBusStop("Kerami").createConnection(6, 5, BusNetwork.getBusStop("Filoti Platanos"));
        BusNetwork.getBusStop("Filoti Platanos").createConnection(6, 5, BusNetwork.getBusStop("Filoti Velaki"));
        BusNetwork.getBusStop("Filoti Velaki").createConnection(6, 5, BusNetwork.getBusStop("Danakos"));
        BusNetwork.getBusStop("Danakos").createConnection(6, 5, BusNetwork.getBusStop("Apiranthos Lagkadi"));
        BusNetwork.getBusStop("Apiranthos Lagkadi").createConnection(6, 5, BusNetwork.getBusStop("Apiranthos Pappas"));
        BusNetwork.getBusStop("Apiranthos Pappas").createConnection(6, 5, BusNetwork.getBusStop("Apiranthos"));
        BusNetwork.getBusStop("Apiranthos").createConnection(6, 5, BusNetwork.getBusStop("Stavros Keramotis"));
        BusNetwork.getBusStop("Stavros Keramotis").createConnection(6, 5, BusNetwork.getBusStop("Keramoti"));

        //LOAD LINE 7
        BusNetwork.getBusStop("Moni").createConnection(7, 5, BusNetwork.getBusStop("Halki"));
        BusNetwork.getBusStop("Halki").createConnection(7, 5, BusNetwork.getBusStop("Halki Church"));
        BusNetwork.getBusStop("Halki Church").createConnection(7, 5, BusNetwork.getBusStop("Damarionas"));
        BusNetwork.getBusStop("Damarionas").createConnection(7, 5, BusNetwork.getBusStop("Damalas"));
        BusNetwork.getBusStop("Damalas").createConnection(7, 5, BusNetwork.getBusStop("Sagkri"));
        BusNetwork.getBusStop("Sagkri").createConnection(7, 5, BusNetwork.getBusStop("Kato Sagri"));
        BusNetwork.getBusStop("Kato Sagri").createConnection(7, 5, BusNetwork.getBusStop("Galanado"));
        BusNetwork.getBusStop("Galanado").createConnection(7, 5, BusNetwork.getBusStop("Ab Market"));
        BusNetwork.getBusStop("Ab Market").createConnection(7, 5, BusNetwork.getBusStop("Hospital"));
        BusNetwork.getBusStop("Hospital").createConnection(7, 5, BusNetwork.getBusStop("Naxos Town / Port"));

        //LOAD LINE 8
        BusNetwork.getBusStop("Naxos Town / Port").createConnection(8, 5, BusNetwork.getBusStop("Municipal Parking"));
        BusNetwork.getBusStop("Municipal Parking").createConnection(8, 5, BusNetwork.getBusStop("High School"));
        BusNetwork.getBusStop("High School").createConnection(8, 5, BusNetwork.getBusStop("Hospital"));
        BusNetwork.getBusStop("Hospital").createConnection(8, 5, BusNetwork.getBusStop("Agios Stylianos"));
        BusNetwork.getBusStop("Agios Stylianos").createConnection(8, 5, BusNetwork.getBusStop("Aggidia"));

        //LOAD LINE 9
        BusNetwork.getBusStop("Tsikalario").createConnection(9, 5, BusNetwork.getBusStop("Ano Potamia"));
        BusNetwork.getBusStop("Ano Potamia").createConnection(9, 5, BusNetwork.getBusStop("Mesi Potamia"));
        BusNetwork.getBusStop("Mesi Potamia").createConnection(9, 5, BusNetwork.getBusStop("Kato Potamia"));
        BusNetwork.getBusStop("Kato Potamia").createConnection(9, 5, BusNetwork.getBusStop("Ab Market"));
        BusNetwork.getBusStop("Ab Market").createConnection(9, 5, BusNetwork.getBusStop("Hospital"));
        BusNetwork.getBusStop("Hospital").createConnection(9, 5, BusNetwork.getBusStop("Naxos Town / Port"));

        //LOAD LINE 10
        BusNetwork.getBusStop("Naxos Town / Port").createConnection(10, 5, BusNetwork.getBusStop("Elli's Park"));
        BusNetwork.getBusStop("Elli's Park").createConnection(10, 5, BusNetwork.getBusStop("Cinema Naxos"));
        BusNetwork.getBusStop("Cinema Naxos").createConnection(10, 5, BusNetwork.getBusStop("Princess Hotel"));
        BusNetwork.getBusStop("Princess Hotel").createConnection(10, 5, BusNetwork.getBusStop("Naxos Camping"));
        BusNetwork.getBusStop("Naxos Camping").createConnection(10, 5, BusNetwork.getBusStop("Naxos Palace"));
        BusNetwork.getBusStop("Naxos Palace").createConnection(10, 5, BusNetwork.getBusStop("Lagos Mare"));
        BusNetwork.getBusStop("Lagos Mare").createConnection(10, 5, BusNetwork.getBusStop("Gas Station"));
        BusNetwork.getBusStop("Gas Station").createConnection(10, 5, BusNetwork.getBusStop("Agios Prokopios"));
        BusNetwork.getBusStop("Agios Prokopios").createConnection(10, 5, BusNetwork.getBusStop("Agia Anna 1st"));
        BusNetwork.getBusStop("Agia Anna 1st").createConnection(10, 5, BusNetwork.getBusStop("Agia Anna Parking"));
        BusNetwork.getBusStop("Agia Anna Parking").createConnection(10, 5, BusNetwork.getBusStop("Agia Anna 2nd"));
        BusNetwork.getBusStop("Agia Anna 2nd").createConnection(10, 5, BusNetwork.getBusStop("Kapares"));


        //LOAD WALKING ROUTES
        BusNetwork.getBusStop("Portara of Naxos").createConnection(20, 10, BusNetwork.getBusStop("Naxos Town / Port"));
    }

    public static void loadAllStops(){
        SystemMessage.sendInformation("System is loading all stops");

        //WALKING POSITIONS
        new BusStop("Portara of Naxos", 37.110184,25.372300, true);

        //BUS STATIONS
        new BusStop("Naxos Town / Port", 37.107758,25.374239);
        new BusStop("Municipal Parking", 37.106950,25.378722);
        new BusStop("Hospital", 37.102171,25.380369);
        new BusStop("Elli's Park", 37.101555,25.380589);
        new BusStop("National Bank", 37.099459,25.380246);
        new BusStop("Cinema Naxos", 37.097427,25.379929);
        new BusStop("Princess Hotel", 37.092853,25.374297);
        new BusStop("Naxos Camping", 37.085685,25.371474);
        new BusStop("Naxos Palace", 37.082000,25.355424);
        new BusStop("Lagos Mare", 37.079017,25.352962);
        new BusStop("Gas Station", 37.076197,25.352152);
        new BusStop("Agios Prokopios", 37.073355,25.352098);
        new BusStop("Agia Anna 1st", 37.069404,25.354781);
        new BusStop("Agia Anna Parking", 37.068861,25.356288);
        new BusStop("Agia Anna Port", 37.066922,25.356052);
        new BusStop("Paradise Restaurant", 37.062620,25.355274);
        new BusStop("Maragas", 37.060685,25.357071);
        new BusStop("Italika", 37.059298,25.358392);
        new BusStop("Plaka Voula", 37.057868,25.359893);
        new BusStop("Placafe / Aegean", 37.056610,25.361171);
        new BusStop("Three Brothers", 37.055518,25.362973);
        new BusStop("Dolphin", 37.053716,25.366690);
        new BusStop("Plaka Camping", 37.053099,25.367527);
        new BusStop("Petrino", 37.052144,25.368782);
        new BusStop("Plaza Hotel", 37.049918,25.371449);
        new BusStop("Orkos Beach", 37.037715,25.378749);
        new BusStop("Parthena Beach", 37.035338,25.376925);
        new BusStop("Mikri Vigla Konthos", 37.029594,25.372621);
        new BusStop("Mikri Vigla Beach", 37.026639,25.372589);

        new BusStop("Vallindra", 37.101581,25.381045);
        new BusStop("Galanado", 37.074733,25.409975);
        new BusStop("Kato Sagri", 37.049550,25.436347);
        new BusStop("Sagkri", 37.047207,25.438134);
        new BusStop("Damalas", 37.055004,25.467133);
        new BusStop("Damarionas", 37.052089,25.478463);
        new BusStop("Halki Church", 37.058810,25.475249);
        new BusStop("Halki", 37.062864,25.482754);
        new BusStop("Kaloxylos", 37.063419,25.487045);
        new BusStop("Kerami", 37.058844,25.490518);
        new BusStop("Filoti Platanos", 37.052123,25.497893);
        new BusStop("Filoti Velaki", 37.046971,25.495025);
        new BusStop("Danakos", 37.046480,25.503912);
        new BusStop("Apiranthos Lagkadi", 37.068878,25.518406);
        new BusStop("Apiranthos Pappas",  37.070924,25.520610);
        new BusStop("Apiranthos", 37.072756,25.522306);
        new BusStop("Stavros Keramotis", 37.105854,25.525153);
        new BusStop("Argokili Crossroad", 37.113825,25.539559);
        new BusStop( "Lionas Crossroad", 37.115428,25.537244);
        new BusStop("Koronos", 37.118984,25.534022);
        new BusStop("Skado", 37.125888,25.537370);
        new BusStop("Skado Seladi", 37.127141,25.539011);
        new BusStop("Komiaki", 37.145363,25.530450);
        new BusStop("Apollonas Kouros", 37.179435,25.548404);
        new BusStop("Apollonas", 37.180164,25.548531);
        new BusStop("Azalas", 37.082809,25.580719);
        new BusStop("Moutsouna Volakas",  37.078319,25.582902);
        new BusStop("Moutsouna - Port", 37.077823,25.586277);

        new BusStop("Galanado Tzanini", 37.077388,25.401170);
        new BusStop("Glinado Church", 37.073491,25.400234);
        new BusStop("Glinado", 37.071433,25.401692);
        new BusStop("Agios Arsenios", 37.064494,25.394912);
        new BusStop("Vivlos Church", 37.059905,25.405511);
        new BusStop("Vivlos", 37.060196,25.409064);
        new BusStop("Vivlos Banikos", 37.057373,25.409453);
        new BusStop( "Camp", 37.013697,25.396961);
        new BusStop("Agia Paraskevi",  37.016960,25.391694);
        new BusStop("Mikri Vigla", 37.022190,25.373608);
        new BusStop("Stratouris",  37.025518,25.375815);
        new BusStop( "Kastraki Beach",  37.004285,25.385470);
        new BusStop("Kastraki Apolafsi", 36.996895,25.394123);
        new BusStop("Glyfada", 36.992899,25.395388);
        new BusStop("Alyko Faros",  36.986230,25.392712);
        new BusStop("Alyko",  36.980625,25.391532);
        new BusStop("Pyrgaki Finikas",  36.977799,25.387502);
        new BusStop("Pyrgaki Kottakis",  36.977617,25.401161);
        new BusStop("Pyrgaki",  36.976010,25.403345);

        new BusStop("Agios Thalellaios",  37.096694,25.421610);
        new BusStop("Melanes",  37.090772,25.437420);
        new BusStop("Kourounohori", 37.094302,25.443245);
        new BusStop( "Miloi", 37.088035,25.446587);
        new BusStop("Kinidaros", 37.101221,25.479208);

        new BusStop("Galini", 37.117035,25.425366);
        new BusStop("Eggares", 37.116703,25.434083);
        new BusStop("Moni Faneromenis", 37.143021,25.465007);
        new BusStop("Hilia Vrysi", 37.155882,25.472957);
        new BusStop("Kampos Komiakis", 37.162518,25.481144);
        new BusStop("Abram",  37.172632,25.480961);
        new BusStop("Agioi Theodoroi",  37.185270,25.498654);
        new BusStop("Agia",  37.184958,25.519876);
        new BusStop("Kouros Apollona",  37.180029,25.547814);
        new BusStop("Apollonas Port",  37.182080,25.551892);

        new BusStop("Keramoti", 37.108742,25.516218);

        new BusStop("Moni", 37.082883,25.496646);
        new BusStop("Ab Market", 37.098596,25.384830);

        new BusStop("High School", 37.102633,25.380090);
        new BusStop("Agios Stylianos", 37.098887,25.390065);
        new BusStop( "Aggidia", 37.097732,25.399026);

        new BusStop("Tsikalario", 37.063890,25.472133);
        new BusStop("Ano Potamia", 37.070949,25.449114);
        new BusStop("Mesi Potamia", 37.068434,25.442477);
        new BusStop("Kato Potamia", 37.067679,25.434866);

        new BusStop("Agia Anna 2nd", 37.067141,25.358449);
        new BusStop( "Kapares", 37.065763,25.361485);
    }
}
