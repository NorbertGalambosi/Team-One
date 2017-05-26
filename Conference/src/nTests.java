import ConferencePersistence.Controller.Controller_PcMember;
import ConferencePersistence.Repository.Repository_PcMember;
import DomainClasses.PcMember;

/**
 * Created by Waiting on 24-May-17.
 */
public class nTests {
    public static void main(String[] args){
        Repository_PcMember repository_pcMember = new Repository_PcMember();
        Controller_PcMember ctrl = new Controller_PcMember(repository_pcMember);
        //PcMember pc1 = new PcMember(1,"Viorelius","Camin","viorelius@maxim.adi","daGreat.com","Viorelius","Sirenul",true);
        //pc1.setType("Chair");
        //repository_pcMember.save(pc1);
        //pc1.setType("Author");
        //repository_pcMember.addType(pc1.getid(),"Author");
        //PcMember pcMember = new PcMember();
        //pcMember = repository_pcMember.findOne(1);
        //System.out.println(pcMember.toString());
//        PcMember pcMember = new PcMember(2,"Jingasul","Camin","jingas@kris.96","kristi.best","jingasul","kristi",true);
//        pcMember.setType("Chair");
//        pcMember.setType("Reviewer");
        //repository_pcMember.save(pcMember);
        //repository_pcMember.addType(2,"Reviewer");
//        for(Integer p:repository_pcMember.findByType("Reviewer"))
//            System.out.println(p);
//        PcMember pc = repository_pcMember.findByUserPass("jingasul","kristi");
//        for(String s:pc.getType())
//            System.out.println(s);
        System.out.println(ctrl.findByUserPass("jingasul","kristi"));
    }
}
