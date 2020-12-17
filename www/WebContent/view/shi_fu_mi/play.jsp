
<h3>Vous n'avez qu'à choisir la bonne combinaison et cliquer sur valider pour voir si vous avez gagner =)</h3>

<form method="POST" action="<%=request.getContextPath()+"/shi-fu-mi/send-combinaison"%>" name="myGame">

	<div class="container-label-shi">
		<input class="input-shi-fu-mi" type="radio" checked="checked" value="1" name="combinaison" id="combinaison1"/>
		<label class="shi-fu-mi" for="combinaison1">
				<img class="shi-1" src="<%=request.getContextPath()+"/ROOT/images/shi.jpg"%>" >
		</label>
	</div>			
	
	
	<div class="container-label-shi">
		<input class="input-shi-fu-mi" type="radio" name="combinaison" value="2" id="combinaision2"/>
		<label class="shi-fu-mi" for="combinaison2">
				<img class="shi-2" src="<%=request.getContextPath()+"/ROOT/images/shi.jpg"%>" >
				
		</label>
	</div>
	<div class="container-label-shi">
		<input class="input-shi-fu-mi" type="radio" name="combinaison" value="3" id="combinaision3" />
		<label class="shi-fu-mi" for="combinaison3">
				<img class="shi-3" src="<%=request.getContextPath()+"/ROOT/images/shi.jpg"%>" >
				
		</label>
	</div>
	
	<div class="button">
		<input type="submit" value="Valider">
	</div>
	
</form>



