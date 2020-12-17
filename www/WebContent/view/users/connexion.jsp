<div>


<h2 class="center">Connexion</h2>



<form method="POST" action="<%=request.getContextPath()+"/users/request-connexion" %>" >
	<div class="errors">
		${ Errors.get("warning")!=null ? String.join("<br />", Errors.get("warning")) : ""}
	</div>

	<div>
		<input type="text" class="${ User.get("email")!=null? "errors" : "" }" value="${ User.get("email")!=null? User.get("email") :"" }" name="email" placeholder="Votre adresse email">	
		<span class="errors">${ Errors.get("email")!=null ? String.join("<br />", Errors.get("email")) : ""}</span>
	</div>
	
	<div>
		<input type="password" class="${ User.get("password")!=null? "errors" : "" }" value="${ User.get("password")!=null? User.get("password") :"" }" name="password" placeholder="votre mot de passe">
		<span class="errors">${ Errors.get("password")!=null ? String.join("<br />", Errors.get("password")) : ""}</span>
	</div>
	
	<div class="button">
		<input type="submit" value="Se connecter">
	</div>
</form>

<div class="center no-account">Vous n'avez pas de compte ? <a href="<%=request.getContextPath()+"/users/inscription" %>" > Créez en un </a></div>






</div>