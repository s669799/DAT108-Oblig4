class DeltagerManager {
    #regElm;
    #form;

    constructor() {
        this.#form = document.getElementById("deltager");
        this.#form.addEventListener("submit", (event) => { this.#registrerdeltager(event) });
    }

    #registrerdeltager(event) {

        const fornavnReg = /^[A-ZÆØÅ][a-zæøå]+(?:[- ][A-ZÆØÅ][a-zæøå]+)*?$/gu;
        const etternavnReg = /^[A-ZÆØÅ][a-zæøå]+(-[A-ZÆØÅ][a-zæøå]+)*?$/gu;
        const mobilReg = /^\d{8}$/gu;
        const passordReg = /^[A-ZÆØÅa-zæøå0-9]{3,20}$/gu;

        const fornavnInput = this.#form.getElementsByTagName("input")[0];
        const etternavnInput = this.#form.getElementsByTagName("input")[1];
        const mobilInput = this.#form.getElementsByTagName("input")[2];
        const passordInput = this.#form.getElementsByTagName("input")[3];
        const passordRepInput = this.#form.getElementsByTagName("input")[4];

        const validityState0 = fornavnInput.validity;
        const validityState1 = etternavnInput.validity;
        const validityState2 = mobilInput.validity;
        const validityState3 = passordInput.validity;
        const validityState4 = passordRepInput.validity;

        fornavnInput.setCustomValidity("");
        etternavnInput.setCustomValidity("");
        mobilInput.setCustomValidity("");
        passordInput.setCustomValidity("");
        passordRepInput.setCustomValidity("");

        let fornavn = fornavnInput.value.match(fornavnReg);
        if (fornavn != null) {
            fornavn = fornavn[0];
            console.log(fornavn);
        }

        let etternavn = etternavnInput.value.match(etternavnReg);
        if (etternavn != null) {
            etternavn = etternavn[0];
            console.log(etternavn);
        }

        let mobil = mobilInput.value.match(mobilReg);
        if (mobil != null) {
            mobil = mobil[0];
            console.log(mobil);
        }

        let passord = passordInput.value.match(passordReg);
        if (passord != null) {
            passord = passord[0];
            console.log(passord);
        }

        let passordRep = passordRepInput.value.match(passordReg);
        if (passordRep != null) {
            passordRep = passordRep[0];
            console.log(passordRep);
        }

        const kjonn = this.#form.getElementsByTagName("input")[5].value;

        fornavnInput.setCustomValidity("");
        etternavnInput.setCustomValidity("");
        mobilInput.setCustomValidity("");
        passordInput.setCustomValidity("");
        passordRepInput.setCustomValidity("");


        if (fornavn === null) {
            fornavnInput.setCustomValidity("Fornavnet ditt er feil.");
            event.preventDefault();

        } else if (etternavn === null) {
            etternavnInput.setCustomValidity("Etternavnet ditt er feil.");

        } else if (mobil === null) {
            mobilInput.setCustomValidity("Mobilnummeret ditt er feil.");
            event.preventDefault();

        } else if (passord === null) {
            passordInput.setCustomValidity("Passordet ditt er feil.");
            event.preventDefault();
            
        } else if (passord !== passordRep) {
            passordRepInput.setCustomValidity("Passordene matcher ikke.");
            event.preventDefault();

        } else {
            fornavnInput.setCustomValidity("");
            etternavnInput.setCustomValidity("");
            mobilInput.setCustomValidity("");
            passordInput.setCustomValidity("");
            passordRepInput.setCustomValidity("");
            event.preventDefault();
          
            let deltager = {
                "fornavn": fornavn, "etternavn": etternavn, "mobil": mobil,
                "passord": passord, "passordRep": passordRep
            }

        }
        fornavnInput.value = null;
        etternavnInput.value = null;
        mobilInput.value = null;
        passordInput.value = null;
        passordRepInput.value = null;


    }

}
const rootelement = document.getElementById("root");
new DeltagerManager();