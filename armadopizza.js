const cocinarPizza = async (minutos) => {
    return new Promise(resolve => setTimeout(() => {
        resolve('Beep! Pizza lista!')
    }, minutos * 1000));
}

const amasar = async (minutos) => {
    return new Promise(resolve => setTimeout(() => {
        resolve('Masa lista!')
    }, minutos * 1000));
}

const hacerUnaGrandeDeMuzza = async () => {
    console.log('Preparar la masa')
    console.log(await amasar(5))
    console.log(await cocinarPizza(10))
    console.log('sacar pizza')
    console.log('pizza lista')
}

hacerUnaGrandeDeMuzza()