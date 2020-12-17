# JavaReflexionServlet

Vous trouverez une méthode de reflexion situé dans www/albin/Servlet
qui parsera l'Url envoyé lors d'une requête.
Celle ci va chercher une méthode qui se situe dans la racine www.bll et la fonction associée.

cela permet de créer une seul et unique Servlet.

 <h2>************ SERVLET ******************** </h2></br>
cette servlet accepte les arguments passés en paramètre dans l'URL : <br/>
    EX => /myApp/users/my-dashboard/1 </br>
      Racine : /myApp </br>
      ContextPath : users/my-dashboard/1 <br/>
      Controller : Users <br/>
      Method : my_dashboard <br/>
      Argument : 1 <br/>
    
 L'argument 1 est passé en parametre dans la fonction my_dahsborad format String : <br/>
 <pre>  
   <code>
    //CONTROLLER
      public Class Users{
          //METHOD
          public static void my_dashboard(String param1){
              system.out.println("mon params => "+param1); // expected : mon params => 1
          }
          
       }
   </code>  
</pre> 

   www.albin.SESSION.java <br/>
   <h2>************ SESSION ********************</h2></br>  
  Permet de pousser un User dans la Seesion courrante de l'application.
     
   www.albin.GLOBALS.java <br/> 
  <h2>************ GLOBALS ********************</h2></br>   
   La class GLOBALS regroupera permet de récupérer le HttpServletRequest et HttpServletResponse ainsi que le Controller et la fonction passé en paramètre.
   Vous pourrez ainsi y accéder tout au travers de vos classes.


   www.albin.Template.java <br/>
   <h2>************ Template ********************</h2></br>  
   La class template permet de définir le template .jsp/html .. à inclure dans la page courante.
   De base, il sera toujours inclut le template "PageLayout" qui regroupe le Header et le footer du site.
   
   www.utils <br/>
   <h2>************ UTILS ********************</h2></br>    
       www.utils.Attributes => class permetant de récupérer les attibutes sous forme de HashMap suite à un requete POST<br/>
       www.utils.Translate => class permetant de la traduction en une autre lang du corps Html. Cette classe s'etend dans tous lme corps du site. <br/>
          Un HashMap de phrase traduite sera récupérer sur une base de donnée.
          Elle n'est pas actif dans cette exemple mais pourra etre utilisé dans le corps Html comme ceci : <br/>
          ${Translate.get("ma phrase à traduire")} <br/>
       www.utils.Path => class permetant de définir les links de vos dossiers <br/>
   
 <h2>************ WEB.XML ********************</h2></br>
Le fichier web.xml aura pour configuration la suivante : 

      <web-app>
         // DEFINITION DE LA SERVLET PRINCIPAL
         <servlet>
              <servlet-name>Servlets</servlet-name> 
              <servlet-class>www.albin.Servlet</servlet-class> 
          </servlet>

           // REDIRECTION DU CHEMIN / VERS LA SERVLET
          <servlet-mapping>
              <servlet-name>Servlets</servlet-name> 
              <url-pattern>/</url-pattern> 
          </servlet-mapping>

           // REDIRECTION DU CHEMIN ROOT VERS LE DOSSIER ROOT (CSS, IMAGES etc ..)
          <servlet-mapping>
              <servlet-name>default</servlet-name> 
              <url-pattern>/ROOT/*</url-pattern> 
          </servlet-mapping>

           // REDIRECTION DU CHEMIN LOGS VERS LE DOSSIER LOGS POUR LE DEBUGGAGE
          <servlet-mapping>
              <servlet-name>default</servlet-name> 
              <url-pattern>/logs/*</url-pattern> 
          </servlet-mapping>

          // REDIRECTION 404 
          <error-page>
              <error-code>404</error-code> 
              <location>/view/errors/errors.jsp</location> 
          </error-page>
      </web-app>

  
  
