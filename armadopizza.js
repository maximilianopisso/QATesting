
async function amasar(tiempo) {
    return new Promise(resolve => setTimeout(() => {
        resolve("** La masa esta lista **");
    }, tiempo * 1000));
}

async function leudarMasa(tiempo) {
    return new Promise(resolve => setTimeout(() => {
        resolve("** La masa esta leudada **");
    }, tiempo * 1000));
}

async function cocinarPizza(tiempo) {
    return new Promise(resolve => setTimeout(() => {
        resolve(`** La pizza se cocino por ${tiempo * 5} minutos **`);
    }, tiempo * 1000));
}

async function comerPizzaMuzzarella() {
    console.log("1 - Precalentar el horno.");
    console.log("2 - Reunir todos los ingredientes y preparar masa.");
    console.log(await amasar(3));
    console.log("3 - Dejar leudar.");
    console.log(await leudarMasa(3));
    console.log("4 - Estirar sobre placa pizzera y pre-cocinar.");
    console.log(await cocinarPizza(3));
    console.log("5 - Colocar salsa, muzzarella y terminar de cocinar.");
    console.log(await cocinarPizza(5));
    console.log("6 - Retirar pizza del horno.");
    console.log("7 - Realizar Corte en 8 porciones.");
    console.log("8 - A disfrutar !! ");
}

comerPizzaMuzzarella()