package com.miniforum.service;

import com.miniforum.dao.UtilisateurRepository;
import com.miniforum.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * Fournit des informations utilisateur de base
     * Spécifie la colonne des roles
     *
     * @param pseudo
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByPseudo(pseudo);
        UserDetails userDetails = null;
        if (utilisateur.getInscription() != null) {
            userDetails = new User(pseudo, utilisateur.getPassword(), AuthorityUtils.createAuthorityList(utilisateur.getRole()));
        }
        return userDetails;
    }
}
