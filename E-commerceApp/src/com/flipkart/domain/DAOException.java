package com.flipkart.domain;
//make a generic checked or unchecked exception depending on context or requirement by extending corresponding class 
public class DAOException extends Exception
{
public DAOException(String errmsg, Throwable ex)
{
	super(errmsg, ex);
}
}
