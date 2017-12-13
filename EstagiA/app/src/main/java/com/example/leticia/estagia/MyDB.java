package com.example.leticia.estagia;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDB {
    public static boolean firstExecution = true;
    public static String ra = "";
    private static HashMap<String, User> users = new HashMap<String, User>();
    private static HashMap<String, Opportunity> opportunities = new HashMap<String, Opportunity>();
    private static HashMap<String, Event> events = new HashMap<String, Event>();

    public static void populateDB() {
        if(firstExecution) {
            //add the 4 users the system starts with
            MyDB.addUser(new User("Leticia", "551724", "BCC", "leticia@mail.com", "senha", false));
            MyDB.addUser(new User("Marcelo", "111111", "BCC", "marcelo@mail.com", "senha", false));
            MyDB.addUser(new User("Jorge", "551678", "BCC", "jorge@mail.com", "senha", false));
            MyDB.addUser(new User("Juliano", "333333", "BCC", "juliano@mail.com", "senha", false));

            //add the opportunities the system starts with
            MyDB.addOpportunity(new Opportunity("Google", "São Paulo", "logo_google", "20/01/2018", "https://careers.google.com/students/", "Google's software engineers develop the next-generation technologies that change how billions of users connect, explore, and interact with information and one another. Our products need to handle information at massive scale, and extend well beyond web search. We\\'re looking for engineers who bring fresh ideas from all areas, including information retrieval, distributed computing, large-scale system design, networking and data storage, security, artificial intelligence, natural language processing, UI design and mobile; the list goes on and is growing every day. As a software engineer, you will work on a specific project critical to Google’s needs with opportunities to switch teams and projects as you and our fast-paced business grow and evolve. We need our engineers to be versatile, display leadership qualities and be enthusiastic to take on new problems across the full-stack as we continue to push technology forward.\nAs a key member of a small and versatile team, you design, test, deploy and maintain software solutions."));
            MyDB.addOpportunity(new Opportunity("Apple", "São Paulo", "logo_apple", "31/12/2017", "https://www.apple.com/jobs/br/", "Na Apple, não criamos apenas produtos. Criamos maravilhas que já revolucionaram setores inteiros. A diversidade de pessoas e ideias inspira a inovação em tudo o que fazemos, da tecnologia de ponta ao nosso compromisso com o meio ambiente. Venha para a Apple e ajude a deixar o mundo melhor do que encontramos.\nEm qual área da Apple você se encaixa?"));
            MyDB.addOpportunity(new Opportunity("Microsoft", "São Paulo", "logo_microsoft", "01/01/2018", "https://careers.microsoft.com/students/internships", "At Microsoft, our interns work on projects that matter – and your team will rely on your skills and insights to help deliver those projects to market. You’ll get the opportunity to work on real projects and have fun along the way. This is your chance to show off your skills and work on cutting-edge technology. We offer internships in all job families and product areas. Imagine yourself as a Microsoft intern. Join Microsoft today, and help us shape the business of tomorrow."));
            MyDB.addOpportunity(new Opportunity("Raccoon", "São Carlos", "logo_raccoon", "15/01/2018", "https://www.raccoon.ag/trabalhe-conosco/", "Se você é desenvolvedor e tem bons conhecimentos em JavaScript vai encontrar desafios bem interessantes conosco. Aliar o conhecimento de AdWords com desenvolvimento é um dos pilares do nosso negócio e isso significa criar tecnologias de vanguarda em um mercado ainda novo. APIs, Scripts, Automação de Lances são algumas das tecnologias que serão aplicadas e desenvolvidas por nós.\nEnvie seu currículo para cv@raccoon.ag com o assunto “Desenvolvedor”"));
            MyDB.addOpportunity(new Opportunity("Daitan", "Campinas", "logo_daitan", "31/01/2018", "http://www.daitangroup.com/about-us/careers/", "We believe every person can make a difference. We develop software and systems that change the world. At Daitan, we strive to make things better every day. So if you share the same goal, then apply now to join our team. We look forward to hearing from you.\nWe celebrate life, and we celebrate success. We develop projects for some of the most successful companies in the world, so there is a lot to celebrate."));
            MyDB.addOpportunity(new Opportunity("CPqD", "Campinas", "logo_cpqd", "02/02/2018", "https://www.cpqd.com.br/o-cpqd/trabalhe-conosco/", "O CPqD conta com um quadro de profissionais altamente especializados em Tecnologia da Informação e Comunicação para o desenvolvimento de sistemas, tecnologias de produto, prestação de serviços tecnológicos e consultorias. Seu programa de pesquisa e desenvolvimento é o maior da América Latina em sua área de atuação.\nCom uma equipe de aproximadamente 1.100 colaboradores, dos quais 84% com formação em nível superior e em sua maioria com cursos de pós-graduação, gera um alto potencial criativo e intelectual.\nO CPqD valoriza a diversidade de seus colaboradores, buscando atrair talentos humanos independentemente de raça, credo, sexo ou deficiência."));

            //add the events the system starts with
            MyDB.addEvent(new Event("Spotify", "Auditório DC", "logo_spotify", "15/12/2017", "Essa semana ocorrerá no auditório do Departamento de Computação uma palestra sobre a empresa Spotify."));
            MyDB.addEvent(new Event("Itaú", "Bento Prado Jr", "logo_itau", "14/12/2017", "Essa semana ocorrerá no Anfiteatro Bento Prado Junior uma palestra do Itaú sobre o processo seletivo."));
            MyDB.addEvent(new Event("Monitora", "Lab II DC", "logo_monitora", "17/12/2017", "Essa semana ocorrerá no Laboratório II do Departamento de Computação uma palestra sobre a empresa Monitora."));
            MyDB.addEvent(new Event("IBM", "Auditório DC", "logo_ibm", "16/12/2017", "Essa semana ocorrerá no auditório do Departamento de Computação uma palestra sobre a empresa IBM."));
            MyDB.addEvent(new Event("Amazon", "Auditório DC", "logo_amazon", "20/12/2017", "Essa semana ocorrerá no auditório do Departamento de Computação uma palestra sobre a empresa Amazon."));
            MyDB.addEvent(new Event("Motorola", "Bento prado Jr", "logo_motorola", "21/12/2017", "Essa semana ocorrerá no Anfiteatro Bento Prado Junior uma palestra sobre a empresa Motorola."));

        }
    }

    /* USERS OPERATIONS */
    public static void clearUsers() {
        users.clear();
    }
    public static void addUser(User user) { users.put(user.getRA(), user);}
    public static HashMap<String, User> getAllUsers() {
        return users;
    }
    public static User getUser(String ra) {
        if(users.containsKey(ra))
            return users.get(ra);
        return null;
    }
    public static void updateUser(User user) {
        users.remove(user.getRA());
        users.put(user.getRA(), user);
    }
    public static void deleteUser(User user) {
        users.remove(user.getRA());
    }

    /* OPPORTUNITIES OPERATIONS */
    public static void clearOpportunities() {
        opportunities.clear();
    }
    public static void addOpportunity(Opportunity opportunity) { opportunities.put(opportunity.getEmpresa(), opportunity);}
    public static HashMap<String, Opportunity> getAllOpportunities() {
        return opportunities;
    }
    public static Opportunity getOpportunity(String empresa) {
        if(opportunities.containsKey(empresa))
            return opportunities.get(empresa);
        return null;
    }

    /* EVENT OPERATIONS */
    public static void clearEvents() {
        events.clear();
    }
    public static void addEvent(Event event) { events.put(event.getEmpresa(), event);}
    public static Event getEvent(String empresa) {
        if(events.containsKey(empresa))
            return events.get(empresa);
        return null;
    }
}
