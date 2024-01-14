<!DOCTYPE html>
<html lang="no">
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> -->
<link href="css/simple.css" rel="stylesheet" type="text/css" />
<!-- <script defer src="javascript/deltager.js"></script> -->
<title>Påmelding</title>
</head>

<body>
  <h2>Påmelding</h2>
  <p style="color: red;">Påmeldingsdetaljer er ugyldige</p>
  <div id="root">
    <form action="paamelding" method="post" id="deltager" >
      <fieldset class="registrering">
        <label>Fornavn</label> <input type="text" name="fornavn" id="fornavn" placeholder="Fornavn" autocomplete="off"/> 
        <label>Etternavn</label> <input type="text" name="etternavn" id="etternavn" placeholder="Etternavn" autocomplete="off" /> 
        <label>Mobil (8 siffer)</label> <input type="text" name="mobil" id="mobil" value="91827364" autocomplete="off" />
        <label>Passord</label> <input type="password" name="passord" id="passord" /> 
        <label>Passord repetert</label> <input type="password" name="passordRep" id="passordRep" /> 
        <label>Kjønn</label>
        <input type="radio" name="kjonn" value="mann" checked="checked" />mann
        <input type="radio" name="kjonn" value="kvinne" />kvinne <br>
        <button type="submit">Meld meg på</button>
      </fieldset>
    </form>
  </div>
</body>
</html>
