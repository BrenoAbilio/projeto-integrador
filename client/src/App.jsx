import FormularioFicha from "./components/FormularioFicha";
import ListaFichas from "./components/ListaFichas";

import styles from "./App.module.css";

function App() {
  return (
    <main className={styles.container}>
      <h1>Alimentação Saudável</h1>

      <FormularioFicha />

      <ListaFichas />
    </main>
  );
}

export default App;