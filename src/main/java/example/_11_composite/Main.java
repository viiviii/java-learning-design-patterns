package example._11_composite;

class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries...");
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        root.add(bin);
        root.add(tmp);
        root.add(usr);

        bin.add(new File("v1", 10000));
        bin.add(new File("latex", 20000));

        root.printList();
        System.out.println();


        System.out.println("Making user entries...");
        Directory youngjin = new Directory("youngjin");
        Directory gildong = new Directory("gildong");
        Directory dojun = new Directory("dojun");

        usr.add(youngjin);
        usr.add(gildong);
        usr.add(dojun);

        youngjin.add(new File("diary.html", 100));
        youngjin.add(new File("Composite.java", 200));

        gildong.add(new File("memo.tex", 300));

        dojun.add(new File("game.doc", 400));
        dojun.add(new File("junk.mail", 500));

        root.printList();
    }
}
