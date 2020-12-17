<div>
	<h2 class="center">Inscription</h2>
	<form name="myForm" method="POST" action="<%=request.getContextPath()+"/users/request-inscription" %>"  >
		<div class="errors" >${Errors.get("warning")!=null? String.join("<br />", Errors.get("warning")) : ""}</div>
		<div>
			<input type="text" value="${User !=null? User.get("name"): ""}" name="name" required placeholder="Votre nom" max="45">
			<span class="errors">${Errors.get("name")!=null? String.join("<br />", Errors.get("name")) : ""}</span>
		</div>
		
		<div>
			<input type="email" value="${User !=null? User.get("email"): ""}" name="email" required placeholder="Votre email" max="45">
			<span class="errors">${ Errors.get("email")!=null? String.join("<br />", Errors.get("email")) : ""}</span>
		</div>
		
		<div>
			<input type="password" value="${User !=null? User.get("password"): ""}" name="password" required placeholder="Votre mot de passe" max="8">
			<span class="errors">${ Errors.get("password")!=null ? String.join("<br />", Errors.get("password")) : ""}</span>
		</div>
		
		<div>
			<input type="text" value="${User !=null? User.get("adresse"): ""}" name="adresse" required placeholder="Libellé et n° de voie" max="45">
			<span class="errors">${Errors.get("adresse")!=null? String.join("<br />", Errors.get("adresse")) : ""}</span>
		</div>
		
		<div>
			<input type="text" value="${User !=null? User.get("ville"): ""}" name="ville" required placeholder="Ville" max="45">
			<span class="errors">${Errors.get("ville")!=null? String.join("<br />", Errors.get("ville")) : ""}</span>
		</div>
		
		<div>
			<input type="text" value="${User !=null? User.get("cp"): ""}" required name="cp" placeholder="Code postal" max="10">
			<span class="errors">${Errors.get("cp")!=null? String.join("<br />", Errors.get("cp")) : ""}</span>
		</div>

		<div class="button">
			<input type="submit"  value="S'inscrire">
		</div>
	
	</form>
</div>