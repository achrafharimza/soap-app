//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2022.07.04 à 03:16:01 PM WEST 
//


package com.concretepage.gs_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="articleInfo" type="{http://www.concretepage.com/article-ws}articleInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "articleInfo"
})
@XmlRootElement(name = "updateArticleRequest")
public class UpdateArticleRequest {

    @XmlElement(required = true)
    protected ArticleInfo articleInfo;

    /**
     * Obtient la valeur de la propriété articleInfo.
     * 
     * @return
     *     possible object is
     *     {@link ArticleInfo }
     *     
     */
    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    /**
     * Définit la valeur de la propriété articleInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleInfo }
     *     
     */
    public void setArticleInfo(ArticleInfo value) {
        this.articleInfo = value;
    }

}
