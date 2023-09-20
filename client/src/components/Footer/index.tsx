import { Section } from './Section';

export const Footer = () => {
  return (
    <div
      className={[
        'grid',
        'grid-cols-6',
        'place-content-evenly',
        'gap-2',
        'items-center',
        'px-[140px]',
        'bg-brand-600',
        'py-8',
      ].join(' ')}
    >
      <h1 className={['font-black', 'text-brand-200', 'text-3xl'].join(' ')}>
        DEVASK
      </h1>
      <Section
        title="INFO"
        elements={[
          { name: 'About', route: '/About' },
          { name: 'Support', route: '/Support' },
          { name: 'Contribute', route: '/contributes' },
        ]}
      />

      <Section
        title="TEAMS"
        elements={[
          { name: 'Web Development', route: '/questions?tag=web' },
          { name: 'UI & UX Design', route: '/questions?tag=UIAndUX' },
          { name: 'Mobile Application', route: '/questions?tag=mobile' },
          { name: 'Data Science', route: '/questions?tag=dataScience' },
        ]}
      />

      <Section
        title="SPONSORS"
        elements={[{ name: 'NULLLESS', route: 'https://nullless-dev.com' }]}
      />

      <Section
        title="ADVERTISE"
        elements={[{ name: 'ads@devask.com', route: 'mailto:ads@devask.com' }]}
      />

      <Section
        title="CONTACT & UPDATES"
        elements={[
          { name: 'LinkedIn', route: 'https://linkedin.com/in/modsyan' },
          { name: 'Twitter', route: 'https://twitter.com/HamdyCL' },
          { name: 'contact@devask.com', route: 'mailto:contact@devask.com' },
        ]}
      />
    </div>
  );
};
