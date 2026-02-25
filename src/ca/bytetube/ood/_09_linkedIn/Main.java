package ca.bytetube.ood._09_linkedIn;


public class Main {
    public static void main(String[] args) {
        LinkedInSystem linkedIn = new LinkedInSystem();
        Account alice = linkedIn.createUser("Alice");
        Account bob = linkedIn.createUser("Bob");
        Account claire = linkedIn.createUser("Claire");

        linkedIn.createFollow(alice, bob);// bob followed alice
        linkedIn.createConnect(alice, claire);//claire connected alice
        Post postAlice = linkedIn.createPost(alice, "what a nice day today !");//alice posted "what a nice day today !"
        Post postBob = linkedIn.createPost(bob, "cold!");//bob posted "cold!"
        linkedIn.createLike(postAlice, claire);// claire liked Alice post
        linkedIn.createComment(postBob, "agree", claire);// claire commented Bob post
        linkedIn.send(alice, claire, postBob); //alice send Bob post to claire

        linkedIn.getNotification(alice);
        linkedIn.getNotification(bob);
        linkedIn.getNotification(claire);
    }
}
