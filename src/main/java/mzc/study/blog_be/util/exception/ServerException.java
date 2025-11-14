package mzc.study.blog_be.util.exception;

public class ServerException extends RuntimeException{

    public ServerException( String msg ){
        super( msg );
    }

    public ServerException(){
        
    }

}
