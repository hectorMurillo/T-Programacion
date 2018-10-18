import java.util.*;

public class Conjunto<T> implements IConjunto<T> {

    Set<T> conjunto = new HashSet<>();

    public Conjunto() {
        this.conjunto = new HashSet<>();
    }

    public Conjunto(Collection<T> conjunto) {
        this.conjunto = new HashSet<>();
        this.conjunto.addAll(conjunto);
    }

    public static void Menu(int opcion){
        Conjunto<String> conjunto1 = new Conjunto<>();
        conjunto1.add("Héctor");
        conjunto1.add("Manuel");
        conjunto1.add("Murillo");
        conjunto1.add("Michael");
        conjunto1.add("Javier");
        Conjunto<Integer> conjunto2 = new Conjunto<>();
        conjunto2.add(1);
        conjunto2.add(2);
        conjunto2.add(3);
        conjunto2.add(4);
        Conjunto<Integer> conjunto2Copy = conjunto2;
        Conjunto<String> aux= new Conjunto<>();
        aux.add("Héctor");
        aux.add("Manuel");
        aux.add("Cristina");
        aux.add("Jorge");
        switch (opcion){
            case 1:
                System.out.println("1. Listar los elementos de un conjunto (toString)---\n");
                System.out.println(conjunto1);
                break;
            case 2:
                System.out.println("2. Igualdad de conjuntos (equals)--\n");
                System.out.println(conjunto2.equals(conjunto2Copy));
                break;
            case 3:
                System.out.println("3. Tamaño del conjunto (size)\n");
                System.out.println("El tamaño del conjuto "+conjunto1+" es: "+ conjunto1.size());
                break;
            case 4:
                System.out.println("4. Conjunto vacío es un conjunto sin elementos (empty)\n");
                System.out.println("El conjunto "+conjunto1+" es vacío ?: "+conjunto1.isEmpty());
                break;
            case 5:
                System.out.println("5. Pertenencia (de un elemento en un conjunto) (contains)\n");
                System.out.println("El elemento Manuel está contenido dentro del conjunto? "+conjunto1+" : "+conjunto1.contains("Manuel"));
                break;
            case 6:
                System.out.println("6. Subconjunto (subset)\n");
                Conjunto<String> sub = new Conjunto<>();
                sub.add("Héctor");
                sub.add("Murillo");
                System.out.println(conjunto1.outPutSubSet(sub));
                break;
            case 7:
                Conjunto<Integer> conjPrueba = new Conjunto<>();
                conjPrueba.add(1);conjPrueba.add(2);conjPrueba.add(3);
                System.out.println("7. Subconjunto propio (subsetP)");
                System.out.println(conjunto2.subsetP(conjPrueba));
                break;
            case 8:
                System.out.println("8. Unión de conjuntos (union)\n");
                Conjunto<Integer> conj = new Conjunto<>();
                conj.add(1);
                conj.add(3);
                System.out.println(conj.union(conjunto1));
                break;
            case 9:
                System.out.println("9. Intersección de conjuntos (intersection) \n");
                System.out.println(conjunto1.interseccion(aux));
                break;
            case 10:

                System.out.println("10. Diferencia de conjuntos (difference) \n");
                System.out.println(conjunto1.diference(aux));
                break;
            case 11:
                System.out.println("11. Complemento de conjuntos (complement)\n");
                ArrayList<Integer> listU = new ArrayList<>();
                for(int i=0;i<10;i++)listU.add(i+1);
                Conjunto<Integer> universal = new Conjunto(listU);
                System.out.println("Tomando al conjunto "+universal+" como Conj Univ. \n"
                                    +"se calcula el complemento del conjunto: "+conjunto2+"\n"+conjunto2.complemento(universal));
                break;
            case 12:
                System.out.println("12. Producto Cartesiano (productC)\n");
                Conjunto<Par<Integer,String>> con = conjunto1.productoC(aux);
                for(int i = 0;i < con.get(0).size();i++){
                    System.out.println(con.get(0).get(i));
                }
                break;
            case 13:
                System.out.println("13. Potencia de un conjunto (pow)\n");
                System.out.println(conjunto1.pow());
                break;
            case  14:
                System.out.println("14. Clonación de un conjunto (clone) (considera clonación profunda)\n");
                Conjunto<String> copyClon = new Conjunto<>();
                copyClon = conjunto1.clone();
                System.out.println(copyClon);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean add(T t) {
        return this.conjunto.add(t);
    }

    @Override
    public Conjunto<T> addAll(Conjunto<T> t) {
        for (T e : t) {
            this.add(e);
        }
        return this;
    }

    @Override
    public int size() {
        int i=0;
        for(T e:this){
            i++;
        }
        return i;
    }

    //Regresará null si el indice [idx] es mayor
    //que el tamaño del conjunto o el indice es negativo.
    //idx va de 0 a n(size)
    @Override
    public T get(int idx) {
        T elementoARegresar = null;
        if(idx < this.size() && idx >= 0)
        {
            int cont = 0;
            for(T e:this)
            {
                if(cont == idx)
                {
                    elementoARegresar = e;
                    break;
                }
                cont++;
            }
        }
        return elementoARegresar;
    }

    @Override
    public boolean contains(Object o) {
        boolean bandera = false;
        for(int i = 0;i < this.size(); i++)
        {
            bandera = this.get(i).equals(o);
            if(bandera)
                break;
        }
        return bandera;
    }

    @Override
    public boolean isEmpty() {
        boolean bandera = false;
        if(this.size() == 0)
        {
            bandera = true;
        }
        return  bandera;
    }

    @Override
    public Iterator<T> iterator() {
        return this.conjunto.iterator();
    }

    public Conjunto<T> clone() {
        Conjunto<T> conjuntoCopia = new Conjunto<>();
        for(T e : this){
            conjuntoCopia.add(e);
        }
        return conjuntoCopia;
        //No entiendo como puedo hacerla en caso de
        //genericos.
        /*try {
            conjuntoCopia = (Conjunto<T>)super.clone();
            return conjuntoCopia;
        } catch (CloneNotSupportedExcepion e) {
            throw new InternalError(e);
        }*/
    }

    public Conjunto<T> union(Object conjunto2) {
        return this.addAll((Conjunto<T>) conjunto2);
    }

    public boolean equals(Conjunto<T> conjunto2){
        boolean bandera = false;
        if(this.size() == conjunto2.size()){
            for(int i = 0; i < this.size(); i++){
                bandera = true;
                if(!conjunto2.contains(this.get(i))){
                    bandera = false;
                    break;
                }
            }
        }
        return bandera;
    }

    public Conjunto<T> interseccion(Conjunto<T> conjunto2){
        Conjunto<T> interseccion = new Conjunto<>();
        for(T e:this){
            for(T e2 :conjunto2){
                if(e.equals(e2)){
                    interseccion.add(e);
                }
            }
        }
        return interseccion;
    }


    //No está bien deberá soportar con un hashmap Conjunto<Par<Integer,String>>
    public Conjunto<Par<Integer,String>> productoC(Conjunto<T> conjunto2){
        Conjunto<Par<Integer,String>> conjuntoPC = new Conjunto<>();
        Par<Integer,String> par = new Par<>();
        Integer i=0;
        for(T e:this){
            for(T e2:conjunto2){
                String elemToAdd = "("+e+","+e2+")";
                par.put(i,elemToAdd);
                conjuntoPC.add(par);
                i++;
            }
        }
        return conjuntoPC;
    }

    @Override
    public String toString() {
        String formato = "{";
        int cont = 0;
        for (T e : this) {
            cont++;
            if(cont < this.size())
            {
                formato += e + ",";
            }else{
                formato += e;
            }
        }
        return formato+"}";
    }

    public boolean subset(Conjunto<T> subConj){
        boolean bandera = false;
        for (T e : subConj){
            bandera = true;
            if(!this.contains(e)){
                bandera = false;
                break;
            }
        }
        return bandera;
    }

    public boolean subsetP(Conjunto<T> subConj){
        boolean band = false;
        if(subset(subConj) && !this.toString().equals(subConj))
            band = true;
        return band;
    }

    public String outPutSubSet(Conjunto <T> subConj){
        return this.subset(subConj) ? subConj.toString() + " es subconjunto del conjunto "+this.toString()
                :subConj.toString()+" NO es subconjunto del conjunto "+this.toString();
    }

    private String deElementoAConjunto(String el){
        String result = "";
        if(!el.equals(""))
            result = "{"+el+"}";
        else
            result = null;
        return  result;
    }

    private String deConjuntoAString(Conjunto<T>conjunto){
        String resultado = "";
        resultado = conjunto.toString();
        resultado = resultado.replaceAll
                    ("\\{","")
                    .replaceAll("\\}","");
        return  resultado;
    }

    public Conjunto<T> complemento(Conjunto<T> cU){
        Conjunto<T> conjuntoComplemento = new Conjunto<>();
        for(T e: this){
            for(T e2 : cU){
                if(e!=e2) conjuntoComplemento.add(e2);
            }
        }
        return conjuntoComplemento;
    }


    public Conjunto<T> subsets(String sub, String elConj, Conjunto<T>conjuntos){
        conjuntos.add((T)deElementoAConjunto(sub));
        String[] elconjArr = elConj.split(",", 2);
        if(elconjArr.length >= 2)
        {
            sub = sub.equals("") ? sub + "": sub + ",";
            subsets(sub+elconjArr[0],elconjArr[1],conjuntos);
            subsets(sub,elconjArr[1],conjuntos);
        }
        return conjuntos;
    }

    public String pow(){
        Conjunto<T> conjuntos = new Conjunto<>();
        conjuntos = this.subsets("",this.deConjuntoAString(this),conjuntos);
        return conjuntos.toString();
    }

    public Conjunto<T> diference(Conjunto<T> conjunto2){
       Conjunto<T> conjuntoARegresar = new Conjunto<>();
       for(T e:this){
           if(!conjunto2.contains(e)){
              conjuntoARegresar.add(e);
           }
       }
       return conjuntoARegresar;
   }
}