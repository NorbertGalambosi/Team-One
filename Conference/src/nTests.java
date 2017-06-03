import ConferencePersistence.Controller.Controller_PcMember;
import ConferencePersistence.Controller.Controller_Proposal;
import ConferencePersistence.Repository.Repository_PcMember;
import ConferencePersistence.Repository.Repository_Proposal;
import DomainClasses.PcMember;
import Validator.Validator_PcMember;
import Validator.Validator_Proposal;

import java.sql.SQLException;

/**
 * Created by Waiting on 24-May-17.
 */
public class nTests {
    public static void main(String[] args){
//        Repository_PcMember repository_pcMember = new Repository_PcMember();
//        Validator_PcMember validator = new Validator_PcMember();
//        Controller_PcMember ctrl = new Controller_PcMember(repository_pcMember,validator);
//
//        PcMember pc1 = new PcMember(1,"Viorelius","Camin","viorelius@maxim.adi","daGreat.com","Viorelius","Sirenul",true);
//        pc1.setType("Chair");
//        try {
//            repository_pcMember.save(pc1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        pc1.setType("Author");
//        repository_pcMember.addType(pc1.getid(),"Author");
//
//        PcMember pcMember = new PcMember(2,"Jingasul","Camin","jingas@kris.96","kristi.best","jingasul","kristi",true);
//        pcMember.setType("Chair");
//        pcMember.setType("Reviewer");
//        try {
//            repository_pcMember.save(pcMember);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        repository_pcMember.addType(2,"Reviewer");
////        for(Integer p:repository_pcMember.findByType("Reviewer"))
////            System.out.println(p);
////        PcMember pc = repository_pcMember.findByUserPass("jingasul","kristi");
////        for(String s:pc.getType())
////            System.out.println(s);
//        System.out.println(ctrl.findByUserPass("jingasul","kristi"));
        Controller_Proposal ctrl = new Controller_Proposal(new Repository_Proposal(),new Validator_Proposal());
        System.out.println(ctrl.findById(1));
        Controller_PcMember controller_pcMember = new Controller_PcMember(new Repository_PcMember(),new Validator_PcMember());
        System.out.print(controller_pcMember.findByUser("jingasul"));
    }
}
